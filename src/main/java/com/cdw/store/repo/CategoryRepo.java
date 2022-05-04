package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
