package com.cdw.store.api;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.Address;
import com.cdw.store.model.AttributeFilter;
import com.cdw.store.service.IAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeResource {
    @Autowired
    private IAttributeService attributeService;
    @GetMapping("/{id}")
    public ResponseEntity<List<AttributeFilter>> getAttributeByCategoryId(@PathVariable("id") Long id){
        List<AttributeFilter> attributeFilters = new ArrayList<>();
       List<String> attributeNames = attributeService.findAttributeNameByCategoryId(id);
        attributeNames.forEach((attributeName) -> {
            AttributeFilter attributeFilter = new AttributeFilter();
            attributeFilter.setName(attributeName);
            attributeFilter.setValues(attributeService.findAttributeValueByNameAndCategoryId(id,attributeName));
            attributeFilters.add(attributeFilter);
        });
        attributeFilters.forEach((e)-> {
            System.out.println(e.getName());
            e.getValues().forEach(t-> System.out.println(t));
        });
        return new ResponseEntity<>(attributeFilters, HttpStatus.OK);
    }
}
