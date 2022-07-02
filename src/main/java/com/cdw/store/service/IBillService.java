package com.cdw.store.service;

import java.util.Date;
import java.util.List;

import com.cdw.store.dto.BillDto;
import com.cdw.store.dto.CheckoutDto;
import com.cdw.store.dto.DetailBillDto;
import com.cdw.store.model.User;

public interface IBillService {
	List<BillDto> findAll();

	List<BillDto> findALlByUserId(Long id);

	Long addBill(CheckoutDto checkoutDto, Date curDate, User user);

	DetailBillDto findById(Long id);
}
