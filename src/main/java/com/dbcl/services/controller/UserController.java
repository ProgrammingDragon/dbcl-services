package com.dbcl.services.controller;

import com.dbcl.services.entity.User;
import com.dbcl.services.model.UserRequest;
import com.dbcl.services.model.UserResponse;
import com.dbcl.services.security.DbclAuthenticationManager;
import com.dbcl.services.service.UserService;
import com.dbcl.services.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private final UserService service;
	private final JwtUtil jwtUtil;
	private final DbclAuthenticationManager manager;

	public UserController(UserService service, JwtUtil jwtUtil, DbclAuthenticationManager manager) {
		this.service = service;
		this.jwtUtil = jwtUtil;
		this.manager = manager;
	}

	@PostMapping("/add")
	public ResponseEntity<Long> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(service.saveUser(user), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest request) {
		manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		return ResponseEntity.ok(new UserResponse(jwtUtil.getGenerateToken(request.getUsername()),
				"User logged in"));
	}

	@PostMapping("/test")
	public ResponseEntity<String> accessAuth(Authentication authentication) {
		return ResponseEntity.ok(String.format("Principal = %s\nRoles = %s", authentication.getName(),
				authentication.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).collect(Collectors.joining(","))));
	}
}
