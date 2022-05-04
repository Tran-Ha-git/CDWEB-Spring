package com.cdw.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.exception.UserNotFoundException;
import com.cdw.store.model.User;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.service.IUserService;

@Service
public class UserService implements IUserService{
	
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public User addUser(User user) {
		user.setUsername("xxx");
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
	
}
