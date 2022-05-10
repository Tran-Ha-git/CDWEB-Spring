package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Bill;
@Repository
public interface BillRepo extends JpaRepository<Bill, Long>{

}
