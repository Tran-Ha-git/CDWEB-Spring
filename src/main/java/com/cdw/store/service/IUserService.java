package com.cdw.store.service;

import java.util.List;

import com.cdw.store.model.User;

public interface IUserService {
	public User addUser(User user);

	public List<User> findALlUsers();

	public User updateUser(User user);

	public void deleteUser(Long id);

	public User findUserById(Long id);
}
