package com.dbcl.services.security;

import com.dbcl.services.entity.User;
import com.dbcl.services.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DbclAuthenticationManager implements AuthenticationManager {
	private final UserRepository repository;
	private final PasswordEncoder encoder;

	public DbclAuthenticationManager(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		User user = repository.findByUsername(authentication.getName());
		if (user == null) {
			throw new UsernameNotFoundException("Invalid user");
		}
		if (encoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
					user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		}
		throw new BadCredentialsException("Invalid credentials.");
	}
}
