package com.cdw.store.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.UserDto;
import com.cdw.store.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {
	@Autowired
	private UserService userService;

	@GetMapping("/checkUsername")
	public ResponseEntity<Boolean> existUsername(@RequestParam String username) {
		boolean result =  userService.existsByUsername(username);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@GetMapping("/checkEmail")
	public ResponseEntity<Boolean> existEmail(@RequestParam String email) {
		boolean result =  userService.existsByEmail(email);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users =  userService.getUsers();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
}
