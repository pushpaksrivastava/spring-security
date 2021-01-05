package com.example.spring.spring_security;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class FirstProjectApplicationTests {

	@Test
	void testPasswordEncoders() {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("password"));
		System.out.println(new SCryptPasswordEncoder().encode("password"));
		
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bCrypt", new BCryptPasswordEncoder());
		encoders.put("sCrypt", new SCryptPasswordEncoder());
		encoders.put("pbkdf", new Pbkdf2PasswordEncoder());
		System.out.println(new DelegatingPasswordEncoder("sCrypt", encoders).encode("password"));
	}

}
