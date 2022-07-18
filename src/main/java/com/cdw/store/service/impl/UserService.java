package com.cdw.store.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.CommentDto;
import com.cdw.store.dto.UserDto;
import com.cdw.store.dto.UserInAdminDto;
import com.cdw.store.exception.UserNotFoundException;
import com.cdw.store.model.Address;
import com.cdw.store.model.Comment;
import com.cdw.store.model.Role;
import com.cdw.store.model.User;
import com.cdw.store.repo.RoleRepo;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.service.IUserService;
import com.cdw.store.utils.UserConverter;

@Service
public class UserService implements IUserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private UserConverter userConverter;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Transactional
	@Override
	public UserDto addUser(UserDto user) {
		List<String> roles = user.getRoles();
		user.setRoles(new ArrayList<String>());
		User entity = userConverter.convertToEntity(user);
		if (roles.size() > 0) {
			for (String nameRole : roles) {
				Optional<Role> role = roleRepo.findByName(nameRole);
				if (role.isPresent()) {
					entity.getRoles().add(role.get());
				}
			}
		}
		Date now = new Date();
		entity.setCreatedDate(now);
		entity.setUpdatedDate(now);
		User savedUser = userRepo.save(entity);
		UserDto result = userConverter.convertToDto(savedUser);
		savedUser.getRoles().forEach(item -> {
			result.getRoles().add(item.getName());
		});
		return result;
	}

	@Override
	public List<User> findALlUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User findUserById(Long id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id = " + id + " was not found"));
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
		return users.stream().map(user -> {
			return userConverter.convertToDto(user);
		}).collect(Collectors.toList());
	}

	@Override
	public Page<UserInAdminDto> getUsersInAdmin(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
		Page<User> users = userRepo.findAll(pageable);
		Page<UserInAdminDto> results = users.map(new Function<User, UserInAdminDto>() {
			@Override
			public UserInAdminDto apply(User entity) {
				UserInAdminDto dto = new UserInAdminDto();
				dto = userConverter.convertToUserInAdminDto(entity);
				dto.setNumAddresses(entity.getAddresses().size());
				dto.setNumComments(entity.getComments().size());

				int numBills = 0;
				if (dto.getNumAddresses() > 0) {
					for (Address address : entity.getAddresses()) {
						numBills += address.getBills().size();
					}
				}
				dto.setNumBills(numBills);
				for (Role role : entity.getRoles()) {
					dto.getRoles().add(role.getName());
				}

				return dto;
			}
		});
		return results;
	}

	@Transactional
	@Override
	public boolean updateDeletedStatus(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			user.get().setStatus(0);// đã dừng
			userRepo.save(user.get());
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean updateDeletedStatus(Long[] ids) {
		for (Long id : ids) {
			if (updateDeletedStatus(id) == false) {
				return false;
			}
		}
		return true;
	}
}
