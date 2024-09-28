package com.pujitha.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pujitha.springboot.entity.SecurityUser;
import com.pujitha.springboot.repository.SecurityRepository;

@Service
public class SecurityUSerService {
	@Autowired
	private SecurityRepository repository;
	
	private BCryptPasswordEncoder endcoder= new BCryptPasswordEncoder(12);
	public SecurityUser saveUser(SecurityUser user)
	{
		user.setUserPassword(endcoder.encode(user.getUserPassword()));
		return repository.save(user);
	}

}
