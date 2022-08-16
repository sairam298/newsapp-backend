package com.wipro.favourites_service.controller;

import java.util.List;

import com.wipro.favourites_service.model.articleModel;
import com.wipro.favourites_service.model.userModel;
import com.wipro.favourites_service.service.serviceImpl;

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
@RequestMapping("/fav")
public class myController {
	
	@Autowired
	serviceImpl serv;
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/{email}/getFav")
	public ResponseEntity<?> getFav(@PathVariable String email)
	{
		List<articleModel> li=serv.getFavourites(email);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@PostMapping("/{email}/addFav")
	public ResponseEntity<?> addFav(@RequestBody articleModel a,@PathVariable String email) {
		try {
			userModel user=serv.setFavourite(email,a);
			return new ResponseEntity<userModel>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
			
		}
	}
	@PostMapping("/{email}/deleteFav")
	public ResponseEntity<?> deleteFav(@RequestBody String url,@PathVariable String email){
		try {
			
			return new ResponseEntity<>(serv.deleteFavourite(email, url),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}
