package com.project.demo.service;

import com.project.demo.models.UserApp;
import com.project.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserApp findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp user = userRepository.findByUsername(username);
		
		if (user != null) {
			var springUser = User.withUsername(user.getUsername())
					.password(user.getPwd())
					.build();
			
			return springUser;
		}
		
		return null;
	}
}
