package com.cdw.store.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.Attribute;
import com.cdw.store.model.Category;
import com.cdw.store.repo.AttributeRepo;
import com.cdw.store.repo.CategoryRepo;
import com.cdw.store.service.IAttributeService;
import com.cdw.store.utils.AttributeConverter;

@Service
public class AttributeService implements IAttributeService {

	@Autowired
	private AttributeRepo attributeRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private AttributeConverter attributeConverter;

	@Override
	public List<String> findAttributeValueByNameAndCategoryId(Long cateId, String name) {
		return attributeRepo.findAttributeValueByNameAndCategoryId(cateId, name);
	}

	@Override
	public List<String> findAttributeNameByCategoryId(Long cateId) {
		return attributeRepo.findAttributeNameByCategoryId(cateId);
	}

	@Transactional
	@Override
	public boolean updateStatus(Long[] ids, String status) {
		for (Long id : ids) {
			Optional<Attribute> entity = attributeRepo.findById(id);
			if (entity.isPresent()) {
				entity.get().setStatus(status);
				attributeRepo.save(entity.get());
			}
		}
		return true;
	}

	@Transactional
	@Override
	public AttributeDto saveAttribute(AttributeDto dto) {
		AttributeDto result = new AttributeDto();
		Attribute savedAttribute = new Attribute();
		Attribute foundAttribute = new Attribute();

		//find existed attribute
		if (dto.getId() != null && dto.getId() > 0) {
			Optional<Attribute> attribute = attributeRepo.findById(dto.getId());
			if (attribute.isPresent()) {
				foundAttribute = attribute.get();
			}
		} 
		
		//Update properties
		BeanUtils.copyProperties(dto, foundAttribute);
		
		//update category
		if (dto.getCategoryId() != null && dto.getCategoryId() > 0) {
			Optional<Category> category = categoryRepo.findById(dto.getCategoryId());
			if (category.isPresent()) {
				foundAttribute.setCategory(category.get());
			}
		}
		
		//save found attribute
		savedAttribute = attributeRepo.save(foundAttribute);

		//set result 
		BeanUtils.copyProperties(savedAttribute, result);
		if(savedAttribute.getCategory()!=null) {
			result.setCategoryId(savedAttribute.getCategory().getId());
		}
		return result;
	}

	@Override
	public boolean existAttributeNameInTheSameCategory(String name, String value, Long categoryId) {
		return attributeRepo.existsByNameAndValueAndCategoryId(name, value, categoryId);
	}
}
