package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Voucher;
@Repository
public interface VoucherRepo extends JpaRepository<Voucher, Long>{

}
