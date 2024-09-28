package com.pujitha.springboot.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pujitha.springboot.entity.SecurityUser;
import com.pujitha.springboot.service.SecurityUSerService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private SecurityUSerService securityUserService;
	
	@PostMapping("/saveUser")
	public SecurityUser saveUser(@RequestBody SecurityUser user)
	{
		return securityUserService.saveUser(user);
	}

}
