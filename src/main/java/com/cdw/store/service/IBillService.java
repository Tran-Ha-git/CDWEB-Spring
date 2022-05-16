package com.cdw.store.service;


import com.cdw.store.dto.BillDto;

import java.util.List;

public interface IBillService {
    List<BillDto> findAll();
    List<BillDto> findALlByUserId(Long id);


}
