package com.dbcl.services.security;

import com.dbcl.services.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	private final JwtUtil jwtUtil;
	private final UserDetailsService detailsService;

	public SecurityFilter(JwtUtil jwtUtil, UserDetailsService detailsService) {
		this.jwtUtil = jwtUtil;
		this.detailsService = detailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
	                                FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token != null) {
			String username = jwtUtil.getUsername(token);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = detailsService.loadUserByUsername(username);
				if (jwtUtil.isValid(token, userDetails.getUsername())) {
					UsernamePasswordAuthenticationToken authToken =
							new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(),
									userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}
