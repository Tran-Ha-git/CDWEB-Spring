package com.cdw.store.service;

import java.util.List;

import com.cdw.store.dto.AttributeDto;

public interface IAttributeService {
	List<String> findAttributeValueByNameAndCategoryId(Long cateId, String name);

	List<String> findAttributeNameByCategoryId(Long cateId);

	boolean updateStatus(Long[] id, String status);

	AttributeDto saveAttribute(AttributeDto dto);

	boolean existAttributeNameInTheSameCategory(String name, String value, Long categoryId);
}
