package com.cdw.store.service;

import java.util.Date;
import java.util.List;

public interface IVoucherService {

	boolean existsByCode(String code, Date currentTime);

	Long useByCode(String code, Date currentTime);

	int appleVoucherForBill(Long billId, List<String> codes);// return number of voucher added
}
