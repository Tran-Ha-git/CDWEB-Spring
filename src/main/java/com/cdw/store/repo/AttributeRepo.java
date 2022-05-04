package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Attribute;

public interface AttributeRepo extends JpaRepository<Attribute, Long>{

}
