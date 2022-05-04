package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Voucher;

public interface VoucherRepo extends JpaRepository<Voucher, Long>{

}
