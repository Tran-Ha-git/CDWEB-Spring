package com.cdw.store.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.LoginDto;
import com.cdw.store.dto.SignupDto;
import com.cdw.store.dto.UserInfoDto;
import com.cdw.store.model.Role;
import com.cdw.store.model.User;
import com.cdw.store.repo.RoleRepo;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.security.jwt.JwtUtils;
import com.cdw.store.security.sevice.UserDetailsImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AuthResource {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginDto, BindingResult bindingResult) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
				.body(new UserInfoDto(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDto signupDto) {
		if (userRepo.existsByUsername(signupDto.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}
		if (userRepo.existsByEmail(signupDto.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email is already taken!");
		}
		User user = new User();
		user.setUsername(signupDto.getUsername());
		user.setPassword(encoder.encode(signupDto.getPassword()));
		user.setEmail(signupDto.getEmail());

		Role role = roleRepo.findByName("client").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		user.getRoles().add(role);
		userRepo.save(user);
		return ResponseEntity.ok("User registered successfully!");
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("You've been signed out!");
	}
}
