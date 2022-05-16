package com.cdw.store.service.impl;

import com.cdw.store.dto.BillDto;
import com.cdw.store.model.Bill;
import com.cdw.store.repo.BillRepo;
import com.cdw.store.service.IBillService;
import com.cdw.store.utils.BillConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService implements IBillService {
    @Autowired
    private BillRepo billRepo;
    @Autowired
    private BillConverter billConverter;
    @Override

    public List<BillDto> findAll() {
        List<Bill> bills = billRepo.findAll();
        List<BillDto> billDtos =  bills.stream().map(billEntity->billConverter.convertToDto(billEntity)).collect(Collectors.toList());
        return billDtos;
    }

    @Override
    public List<BillDto> findALlByUserId(Long id) {
        List<Bill> bills = billRepo.findALlByUserId(id);
        List<BillDto> billDtos =  bills.stream().map(billEntity->billConverter.convertToDto(billEntity)).collect(Collectors.toList());
        return billDtos;
    }
}
