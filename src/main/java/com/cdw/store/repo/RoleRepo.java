package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
