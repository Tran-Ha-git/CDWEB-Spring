package com.cdw.store.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.model.Bill;
import com.cdw.store.model.Voucher;
import com.cdw.store.repo.BillRepo;
import com.cdw.store.repo.VoucherRepo;
import com.cdw.store.service.IVoucherService;

@Service
public class VoucherService implements IVoucherService {
	@Autowired
	private VoucherRepo voucherRepo;

	@Autowired
	private BillRepo billRepo;

	@Override
	public boolean existsByCode(String code, Date currentTime) {
		return voucherRepo
				.existsByCodeAndTimeGreaterThanAndStatusAndStartedDateLessThanEqualAndEndedDateGreaterThanEqual(code, 0,
						1, currentTime, currentTime);
	}

	@Transactional
	@Override
	public Long useByCode(String code, Date currentTime) {
		Optional<Voucher> voucher = voucherRepo
				.findByCodeAndTimeGreaterThanAndStatusAndStartedDateLessThanEqualAndEndedDateGreaterThanEqual(code, 0,
						1, currentTime, currentTime);
		if (voucher.isPresent()) {
			Voucher currentVoucher = voucher.get();
			return currentVoucher.getCost();
		}

		return -1L;// het han
	}

	@Override
	public int appleVoucherForBill(Long billId, List<String> codes) {
		int result = 0;
		Optional<Bill> bill = billRepo.findById(billId);
		if (bill.isPresent()) {
			Bill curBill = bill.get();
			for (String code : codes) {
				Optional<Voucher> voucher = voucherRepo.findByCode(code);
				if (voucher.isPresent()) {
					Voucher curVoucher = voucher.get();
					curVoucher.setTime(curVoucher.getTime() - 1);
					curBill.setVoucher(curVoucher);
					voucherRepo.save(curVoucher);
					result++;
				}
			}
			return result;
		}

		return -1; // error
	}
}
