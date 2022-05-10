package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
