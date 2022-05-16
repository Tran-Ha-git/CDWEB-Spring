package com.cdw.store.utils;

import com.cdw.store.dto.BillDto;
import com.cdw.store.model.Bill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillConverter {
    @Autowired
    private ModelMapper modelMapper;
    public BillDto convertToDto(Bill entity){
        return modelMapper.map(entity, BillDto.class);
    }
}
