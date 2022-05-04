package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.store.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
