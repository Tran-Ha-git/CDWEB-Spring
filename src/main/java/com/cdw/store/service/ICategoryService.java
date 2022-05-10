package com.cdw.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdw.store.dto.CategoryDto;

@Service
public interface ICategoryService {
	
	List<CategoryDto> findAll();
	
}
