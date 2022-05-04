package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
