package com.wedspay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wedspay.entity.User;
import com.wedspay.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user data from database using userName
		User user = userService.getUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Your are not registered !!");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
