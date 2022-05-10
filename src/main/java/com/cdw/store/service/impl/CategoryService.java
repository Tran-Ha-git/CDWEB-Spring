package com.cdw.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.CategoryDto;
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
	
	
}
