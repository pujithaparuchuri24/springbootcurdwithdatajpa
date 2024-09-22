package com.pujitha.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration{
	// we can resolve csrf issue by creating new session every time or samesiteStrict
	//by default spring security has their own configuration 
	//so here we have override the security behavior and enable new session for every request
	//if we use this configuration no need to send x-csrf-token from postman for put,post,delete and patch request
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception
	{
		 return http.csrf(custom->custom.disable()).
		authorizeHttpRequests(request->request.anyRequest().authenticated()).
		httpBasic(Customizer.withDefaults()).
		// formLogin is commented bcoz when we are requesting service it will load form page
		//but it will treat as a new session everytime
		//formLogin(Customizer.withDefaults()).
		sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
		build();
	}
	
	//in memory authentication when we implement then properties file username and password won't work only 
	//the belwo mentioned user details will work
	//for inmemoryuserDeatilsManager class we can send multiple user object
	@Bean
	public UserDetailsService getUserDetailsService()
	{
		UserDetails newUser=User.
					withDefaultPasswordEncoder()
					.username("pujitha-config")
					.password("pujitha@234")
					.roles("user")
					.build();
		
		return new InMemoryUserDetailsManager(newUser);
	}

}
