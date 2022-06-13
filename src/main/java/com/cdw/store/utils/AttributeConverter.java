package com.cdw.store.utils;

import com.cdw.store.dto.AddressDto;
import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.Address;
import com.cdw.store.model.Attribute;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
