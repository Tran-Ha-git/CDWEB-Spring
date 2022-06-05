package com.cdw.store.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdw.store.dto.AddressDto;
import com.cdw.store.dto.UserDto;
import com.cdw.store.model.Address;
import com.cdw.store.model.User;

@Component
public class UserConverter {
	@Autowired
    private ModelMapper modelMapper;
    
    public UserDto convertToDto(User entity){
        return modelMapper.map(entity, UserDto.class);
    }
	
	public User convertToEntity(UserDto dto){
        return modelMapper.map(dto, User.class);
    }
}
