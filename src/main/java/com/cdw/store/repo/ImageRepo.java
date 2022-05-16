package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Image;
@Repository
public interface ImageRepo extends JpaRepository<Image, Long>{

}