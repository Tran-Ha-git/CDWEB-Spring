package com.cdw.store.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.BillDto;
import com.cdw.store.model.Address;
import com.cdw.store.model.Bill;

@Service
public class BillConverter {
	@Autowired
	private ModelMapper modelMapper;

	public BillDto convertToDto(Bill entity) {
		BillDto dto = new BillDto();

		dto = modelMapper.map(entity, BillDto.class);

		Address address = entity.getAddress();
		StringBuilder sb = new StringBuilder();
		sb.append(address.getStreet());
		sb.append(", ");
		sb.append(address.getWard());
		sb.append(", ");
		sb.append(address.getDistrict());
		sb.append(", ");
		sb.append(address.getCity());
		dto.setStringAddress(sb.toString());

		dto.setCurrentPhone(address.getPhone());

		return dto;
	}
}
