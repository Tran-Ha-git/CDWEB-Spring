package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
