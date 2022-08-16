package com.wipro.recommendationApi.controller;

import java.util.List;

import com.wipro.recommendationApi.model.articleModel;
import com.wipro.recommendationApi.model.userModel;
import com.wipro.recommendationApi.service.recommendServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/refer")
public class myController {
	
	@Autowired
	recommendServiceImpl serv;
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/{email}/getRefer")
	public ResponseEntity<?> getRefer(@PathVariable String email)
	{
		List<articleModel> li=serv.getRefers(email);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@PostMapping("/{email}/addRef")
	public ResponseEntity<?> addRef(@RequestBody articleModel a,@PathVariable String email) {
		try {
			userModel user=serv.setRefer(email,a);
			return new ResponseEntity<userModel>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
			
		}
	}
	

}
