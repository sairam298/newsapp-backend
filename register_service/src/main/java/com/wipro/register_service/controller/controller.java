package com.wipro.register_service.controller;

import com.wipro.register_service.exception.userAlreadyExitstException;
import com.wipro.register_service.exception.userDoesNotExistException;
import com.wipro.register_service.service.registerService;
import com.wipro.register_service.user.RequestCredentials;
import com.wipro.register_service.user.userDetails;
import com.wipro.register_service.utility.JWTUtilityClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class controller {
	@Autowired
	registerService serv;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JWTUtilityClass jwtUtil;
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody userDetails u){
		try {
		userDetails add=serv.addUser(u);
		return new ResponseEntity<userDetails>(add,HttpStatus.OK);
		}
		catch(userAlreadyExitstException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	@PostMapping("/{email}/update")
	public userDetails updateUserDetails(@PathVariable String email,@RequestBody userDetails u) {
		System.out.println("Checker");
		userDetails user=serv.updateUser(u);
		System.out.println("Check");
		return user;
	}
	@GetMapping("/{email}/getDetails")
	public ResponseEntity<?> getDetails(@PathVariable String email) throws userDoesNotExistException {
		System.out.println("i too am called");
		userDetails user = serv.getUser(email);
		System.out.println("i am called");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody RequestCredentials requestCredentials) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestCredentials.getEmail(), requestCredentials.getPassword()));
		}
		catch(Exception e) {
			throw new Exception("Invalid Credentials");
		}
		return jwtUtil.generateToken(requestCredentials.getEmail());
	}
	

}
