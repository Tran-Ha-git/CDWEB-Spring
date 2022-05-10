package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
