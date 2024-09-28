package com.pujitha.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pujitha.springboot.entity.SecurityUser;

public interface SecurityRepository extends JpaRepository<SecurityUser, Integer> {
	
	public SecurityUser findByUserName(String name);

}
