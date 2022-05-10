package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Attribute;
@Repository
public interface AttributeRepo extends JpaRepository<Attribute, Long>{

}
