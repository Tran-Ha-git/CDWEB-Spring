package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

}
