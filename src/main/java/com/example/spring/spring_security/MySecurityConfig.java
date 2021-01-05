package com.example.spring.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
////		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		UserDetails user = User.withUsername("John").password(passwordEncoder.encode("Cena")).authorities("read").build();
//		userDetailService.createUser(user);
//		
////		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
//		auth.userDetailsService(userDetailService);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic();
//		http.formLogin();
		http.authorizeRequests().antMatchers("/hello").authenticated();
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
//		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
