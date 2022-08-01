package com.cdw.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.BillInAdminDto;
import com.cdw.store.dto.CategoryDto;
import com.cdw.store.model.Bill;
import com.cdw.store.model.Category;
import com.cdw.store.repo.CategoryRepo;
import com.cdw.store.service.ICategoryService;
import com.cdw.store.utils.CategoryConverter;
@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> results = new ArrayList<CategoryDto>();
		List<Category> categories = categoryRepo.findAll();
		if(categories!=null && categories.size()>0) {
			categories.forEach(category->{
				results.add( categoryConverter.convertToDto(category));
			});
		}
		return results;
	}

	@Override
	public Page<CategoryDto> getCategoriesInAdmin(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
		Page<Category> categories = categoryRepo.findAllByStatus(pageable,"Active");
		Page<CategoryDto> results = categories.map(new Function<Category, CategoryDto>() {
			@Override
			public CategoryDto apply(Category entity) {
				CategoryDto dto = new CategoryDto();
				dto = categoryConverter.convertToDto(entity);
				return dto;
			}
		});
		return results ;
	}
	
	
}
