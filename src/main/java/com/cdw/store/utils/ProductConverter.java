package com.cdw.store.utils;

import org.springframework.stereotype.Service;

import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Product;

@Service
public class ProductConverter {
	public Product convertToEntity(ProductDto dto) {
		Product entity= new Product();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSummary(dto.getDesc());
		entity.setPrice(dto.getPrice());
		return entity;
	}
	
	public ProductDto convertToDto(Product entity) {
		ProductDto dto= new ProductDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDesc(entity.getSummary());
		dto.setPrice(entity.getPrice());
		return dto;
	}
}
