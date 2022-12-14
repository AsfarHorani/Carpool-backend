package com.carpool.service;

import com.carpool.model.User;
import com.carpool.dto.UserDto;
import com.carpool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), Long.toString(user.getNonce()),
				new ArrayList<>());
	}

	public User save(UserDto user) {
		User newUser = new User();
		Random rand = new Random();
        double n = Math.random()*(999999-100000+1)+100000;
        long noice = Double.doubleToLongBits(n);
		newUser.setNonce(noice);
		newUser.setUsername(user.getAddress());
		return userDao.save(newUser);	
	}
}