package com.pujitha.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pujitha.springboot.dto.UserPrincipal;
import com.pujitha.springboot.entity.SecurityUser;
import com.pujitha.springboot.repository.SecurityRepository;


@Component
public class SecureUserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private SecurityRepository repos;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser user= repos.findByUserName(username);
		return new UserPrincipal(user);
	}

}
