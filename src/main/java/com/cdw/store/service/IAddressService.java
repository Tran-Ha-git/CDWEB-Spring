package com.cdw.store.service;

import java.util.List;

import com.cdw.store.dto.AddressDto;
import com.cdw.store.model.Address;

public interface IAddressService {
	public Address addAddress(Address address);

	public List<AddressDto> findALlAddresses();

	public Address updateAddress(Address address);

	public void deleteAddress(Long id);

	public Address findAddressById(Long id);
}
