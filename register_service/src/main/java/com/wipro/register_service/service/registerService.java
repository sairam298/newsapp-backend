package com.wipro.register_service.service;

import java.util.ArrayList;
import java.util.Optional;

import com.wipro.register_service.exception.userAlreadyExitstException;
import com.wipro.register_service.exception.userDoesNotExistException;
import com.wipro.register_service.repository.myRepo;
import com.wipro.register_service.user.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class registerService implements UserDetailsService {
	
	@Autowired
	myRepo repo;
	
	public userDetails addUser(userDetails u) throws userAlreadyExitstException {
		
		Optional<userDetails> newUser= repo.findById(u.getEmail());
		if(newUser.isPresent()) {
			throw new userAlreadyExitstException("The user with same mail id already existed.");
		}
		else {
			userDetails addedUser = repo.save(u);
			return addedUser;
		}
		
	}
	
	public userDetails updateUser(userDetails u) {
		Optional<userDetails> user = repo.findById(u.getEmail());
		user.get().setFirstName(u.getFirstName());
		user.get().setLastName(u.getLastName());
		user.get().setPassword(u.getPassword());
		repo.save(u);
		return user.get();
	}
	
	public userDetails getUser(String email) throws userDoesNotExistException {
		
		Optional<userDetails> newUser=repo.findById(email);
		System.out.println("Entered into function");
		if(newUser.isPresent()) {
			System.out.println("Wow got it");
			return newUser.get();
		}
		else {
			throw new userDoesNotExistException("User details not found. Please register to continue.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<userDetails> user = repo.findById(email);
		
		return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
	}
	
	
}
