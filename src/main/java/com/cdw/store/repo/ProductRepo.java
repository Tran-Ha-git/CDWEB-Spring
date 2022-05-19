package com.cdw.store.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
    @Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE %?1%")
    public List<Product> search(String keyword);
    Page<Product> findByNameContainingIgnoreCase(String q, Pageable pageable);
}
