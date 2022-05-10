package com.cdw.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
