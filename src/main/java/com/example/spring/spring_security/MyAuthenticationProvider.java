package com.example.spring.spring_security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		if("John".equals(userName) && "Cena".equals(password)) {
			return new UsernamePasswordAuthenticationToken(userName, password,Arrays.asList());
		}else {
			throw new BadCredentialsException("Invalid Username or Password");
		}
	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
