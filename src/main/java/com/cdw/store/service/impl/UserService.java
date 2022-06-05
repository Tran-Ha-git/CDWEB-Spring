package com.cdw.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.UserDto;
import com.cdw.store.exception.UserNotFoundException;
import com.cdw.store.model.User;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.service.IUserService;
import com.cdw.store.utils.UserConverter;

@Service
public class UserService implements IUserService{
	
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Autowired
	private UserConverter userConverter; 
	
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public List<User> findALlUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public User updateUser(User user){
		return userRepo.save(user);
	}
	
	@Override
	public void deleteUser(Long id){
		userRepo.deleteById(id);
	}
	
	@Override
	public User findUserById(Long id){
		return userRepo.findById(id).orElseThrow(
				()-> new UserNotFoundException("User by id = "+id+" was not found"));
	}
	
	@Override
	public boolean existsByUsername(String username) {
		return userRepo.existsByUsername(username);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = userRepo.findAll();
		return users.stream().map(user ->{
			return userConverter.convertToDto(user);
		}).collect(Collectors.toList());
	}
}
