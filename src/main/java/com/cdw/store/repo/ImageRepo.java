package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Image;

public interface ImageRepo extends JpaRepository<Image, Long>{

}
