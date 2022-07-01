package com.cdw.store.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.BillDto;
import com.cdw.store.dto.DetailBillDto;
import com.cdw.store.service.impl.BillService;

@RestController
@RequestMapping("/bill")
public class BillResource {
	@Autowired
	private BillService billService;

	@GetMapping("/all")
	public ResponseEntity<List<BillDto>> getAllBills() {
		List<BillDto> bills = billService.findAll();
		return new ResponseEntity<List<BillDto>>(bills, HttpStatus.OK);
	}

	@GetMapping(value = "/allU")
	public ResponseEntity<List<BillDto>> getAllBillsByUserId(@RequestParam("userId") Long id) {
		List<BillDto> bills = billService.findALlByUserId(id);
		return new ResponseEntity<List<BillDto>>(bills, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailBillDto> getBillById(@PathVariable Long id) {
		DetailBillDto bill = billService.findById(id);
		return new ResponseEntity<DetailBillDto>(bill, HttpStatus.OK);
	}
}
