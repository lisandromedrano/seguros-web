package com.lix.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userLoginService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(username);
		return userDetails;
	}
}