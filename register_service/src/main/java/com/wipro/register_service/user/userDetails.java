package com.wipro.register_service.user;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class userDetails {
	@javax.persistence.Id
	String email;
	String firstName;
	String lastName;
	String password;
	
	
	
	public userDetails() {
		super();
		//TODO Auto-generated constructor stub
	}
	public userDetails(String firstName, String lastName, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = emailId;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmailId(String emailId) {
		this.email = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
