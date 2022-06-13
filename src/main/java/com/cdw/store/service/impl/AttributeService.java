package com.cdw.store.service.impl;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.dto.BillDto;
import com.cdw.store.model.Attribute;
import com.cdw.store.model.Bill;
import com.cdw.store.repo.AttributeRepo;
import com.cdw.store.service.IAttributeService;
import com.cdw.store.utils.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AttributeService implements IAttributeService {
    @Autowired
    private AttributeRepo attributeRepo;
    @Autowired
    private AttributeConverter attributeConverter;

    @Override
    public List<String> findAttributeValueByNameAndCategoryId(Long cateId,String name) {
     return attributeRepo.findAttributeValueByNameAndCategoryId(cateId,name);
    }

    @Override
    public List<String> findAttributeNameByCategoryId(Long cateId) {
        return attributeRepo.findAttributeNameByCategoryId(cateId);
    }
}
