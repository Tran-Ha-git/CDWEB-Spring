package com.cdw.store.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.Attribute;

@Component
public class AttributeConverter {
    @Autowired
    private ModelMapper modelMapper;

    public AttributeDto convertToDto(Attribute attribute){
        return modelMapper.map(attribute, AttributeDto.class);
    }

    public Attribute convertToEntity(AttributeDto dto){
        return modelMapper.map(dto, Attribute.class);
    }
}
