package com.masai.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.config.JwtTokenProvider;
import com.masai.dto.LoginDTO;
import com.masai.entity.RolesAndAuthority;
import com.masai.entity.User;
import com.masai.repository.RolesAndAuthorityRepository;
import com.masai.repository.UserRepository;
import com.masai.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private RolesAndAuthorityRepository rar;

	@Autowired
	private AuthenticationManager authmanager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public User addUser(User user) {
		Optional<User> us = ur.findByEmail(user.getEmail());
		if (us.isPresent()) {
			throw new RuntimeException("user already present in database");
		}
		Set<RolesAndAuthority> managedSet = new HashSet<>();
		RolesAndAuthority role = rar.findByName("ROLE_USER")
				.orElseThrow(() -> new RuntimeException("Role not found in database"));

		managedSet.add(role);
        
		user.setAuthSet(managedSet);
		user.setOrders(new ArrayList<>());
		user.setReservations(new ArrayList<>());
		String hashPass= encoder.encode(user.getPassword());
		user.setPassword(hashPass);
		return ur.save(user);
	}

	@Override
	public User update(User user) {
		User useropt = ur.findByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
		Set<RolesAndAuthority> set = user.getAuthSet();
		Set<RolesAndAuthority> managedSet = useropt.getAuthSet();
		for (RolesAndAuthority roles : set) {
			managedSet.add(rar.findByName(roles.getName()).orElseThrow(() -> new RuntimeException("Role Not Found")));
		}

		useropt.setAuthSet(managedSet);
		return ur.save(useropt);
	}

	@Override
	public List<User> findAllUser() {

		return ur.findAll();
	}

	@Override
	public User findByEmail(String email) {
		
		return ur.findByEmail(email).orElseThrow(() -> new RuntimeException("no user find with email"));
	}

	@Override
	public User deletUser(String email) {
		User user = ur.findByEmail(email).orElseThrow(() -> new RuntimeException("no user find with email"));
		ur.delete(user);
		return user;
	}

	@Override
	public String login(LoginDTO logindto) {
		Optional<User> user = ur.findByEmail(logindto.getEmail());
		if (!user.isPresent()) {
			throw new RuntimeException("Wrong Email please provide correct email");
		}
		if (user.isPresent()) {
			User u = user.get();

			if (!encoder.matches(logindto.getPassword(), u.getPassword())) {
				throw new RuntimeException("Wrong password please provide currect password");
			}
		}

		Authentication authentication = authmanager
				.authenticate(new UsernamePasswordAuthenticationToken(logindto.getEmail(), logindto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		return token;
	}
}
