package com.cdw.store.service;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.Attribute;

import java.util.List;

public interface IAttributeService {
    List<String> findAttributeValueByNameAndCategoryId(Long cateId,String name);
    List<String> findAttributeNameByCategoryId(Long cateId);
}
