package com.dbcl.services.service;

import com.dbcl.services.entity.User;
import com.dbcl.services.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	private final PasswordEncoder encoder;

	public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public Long saveUser(User user) {
		user.setUsername(user.getUsername().toUpperCase());
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user).getId();
	}
}
