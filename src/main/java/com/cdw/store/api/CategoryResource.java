package com.cdw.store.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.MenuDto;
import com.cdw.store.model.Category;
import com.cdw.store.repo.CategoryRepo;
import com.cdw.store.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/menu")
	public ResponseEntity<List<MenuDto>> loadMenu(){
		List<MenuDto> menus = new ArrayList<MenuDto>();
		if(categoryService.findAll().size()>0) {
			categoryService.findAll().forEach(category->{
				MenuDto menuDto= new MenuDto();
				menuDto.setCategoryName(category.getName());
				category.getAttributes().forEach(attr->{
					if(attr.getName().equals("THƯƠNG HIỆU")) {
						menuDto.getBrands().add(attr.getValue());
					}
				});
				menus.add(menuDto);
			});
		}
		return new ResponseEntity<>(menus, HttpStatus.OK);
	}
}