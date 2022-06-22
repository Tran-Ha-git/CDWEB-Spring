package com.cdw.store.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.service.IVoucherService;

@RestController
@RequestMapping("/voucher")
public class VoucherResource {
	@Autowired
	private IVoucherService voucherService;

	@GetMapping("/checkCode")
	public ResponseEntity<Boolean> existVoucherCode(@RequestParam String code) {
		Date currentTime = new Date();
		boolean result = voucherService.existsByCode(code, currentTime);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@GetMapping("/useCode")
	public ResponseEntity<Long> useVoucherCode(@RequestParam String code) {
		Date currentTime = new Date();
		Long result = voucherService.useByCode(code, currentTime);
		return new ResponseEntity<Long>(result, HttpStatus.OK);
	}
}
