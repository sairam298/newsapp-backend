package com.wipro.register_service.user;

public class RequestCredentials {
	
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RequestCredentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public RequestCredentials() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	

}
