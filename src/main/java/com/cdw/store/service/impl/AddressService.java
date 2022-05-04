package com.cdw.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.AddressDto;
import com.cdw.store.model.Address;
import com.cdw.store.repo.AddressRepo;
import com.cdw.store.service.IAddressService;
import com.cdw.store.utils.AddressConverter;

@Service
public class AddressService implements IAddressService {
	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private AddressConverter addressConverter;

	@Override
	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public List<AddressDto> findALlAddresses() {
		List<Address> entities = addressRepo.findAll();

		List<AddressDto> results = new ArrayList<>();

		for (Address address : entities) {
			AddressDto result = addressConverter.convertToDto(address);
			results.add(result);
		}

		return results;
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public void deleteAddress(Long id) {
		addressRepo.deleteById(id);
	}

	@Override
	public Address findAddressById(Long id) {
		return addressRepo.findById(id).orElse(null);
	}

}
