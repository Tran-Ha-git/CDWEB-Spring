package com.cdw.store.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.UserDto;
import com.cdw.store.dto.UserInAdminDto;
import com.cdw.store.exception.UserNotFoundException;
import com.cdw.store.model.Address;
import com.cdw.store.model.Role;
import com.cdw.store.model.User;
import com.cdw.store.repo.RoleRepo;
import com.cdw.store.repo.UserRepo;
import com.cdw.store.service.IUserService;
import com.cdw.store.utils.UserConverter;

import net.bytebuddy.utility.RandomString;

@Service
public class UserService implements IUserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private JavaMailSender mailSender;

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
		entity.setUpdatedDate(now);
		if(user.getId()==null) {
			entity.setCreatedDate(now);
			if(user.getPassword()!=null) {
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				entity.setPassword(encodedPassword);	
			}
		}else {
			String encodedPassword = userRepo.findById(user.getId()).get().getPassword();
			entity.setPassword(encodedPassword);
		}
		
		
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
			user.get().setStatus(0);// ???? d???ng
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

	@Transactional
	@Override
	public boolean processForgotPassword(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		if (user.isPresent()) {
			// update token
			String token = RandomString.make(45);
			user.get().setToken(token);

			// generate link
			String link = "http://localhost:4200/reset_password?token=" + token;

			// send mail
			boolean result = sendEmail(email, link, user.get().getUsername());
			return result;

		}
		// "Error: Email kh??ng h???p l???. Vui l??ng ki???m tra l???i.";
		return false;
	}

	private boolean sendEmail(String email, String link, String username) {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);

		try {
			helper.setFrom("ContactHatranShop@gmail.com", "Shop My_Memory support");
			helper.setTo(email);

			String subject = "Qu??n m???t kh???u";
			String content = "<p>Xin ch??o, </p>" + "<p>T??n t??i kho???n c???a b???n l??: <b>" + username + "</b></p>"
					+ "<p>N???u b???n ???? qu??n m???t kh???u</p>" + "<p>Vui l??ng nh???p v??o link sau v?? ?????i l???i m???t kh???u</p>"
					+ "<p><b><a href=\"" + link + "\">?????i m???t kh???u</a></b></p>"
					+ "<br><br><p>B??? qua email n??y n???u b???n nh??? m???t kh???u ho???c kh??ng mu???n l??m theo y??u c???u.</p>";
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(msg);
			// "Success: Vui l??ng ki???m tra mail ????? c???p nh???t l???i m???t kh???u.";
			return true;

		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
			// "Error: L???i trong qu?? tr??nh x??? l??. Vui l??ng th???c hi???n l???i sau.";
		}
		return false;
	}

	@Override
	@Transactional
	public boolean updatePassword(String token, String password) {
		String encodedPassword = passwordEncoder.encode(password);

		Optional<User> user = userRepo.findByToken(token);
		if (user.isPresent()) {
			user.get().setPassword(encodedPassword);
			user.get().setToken(null);
			userRepo.save(user.get());
			return true;
		}
		return false;
	}

	@Override
	public boolean checkValidToken(String token) {
		Optional<User> user = userRepo.findByToken(token);
		return user.isPresent();
	}

}
