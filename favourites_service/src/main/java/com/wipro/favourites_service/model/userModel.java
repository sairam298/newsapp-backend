package com.wipro.favourites_service.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class userModel {
	@Id
	String email;
	public List<articleModel> favArticles;
	
	public userModel() {
		super();
		//TODO Auto-generated constructor stub
	}
	public userModel(String email, List<articleModel> favArticles) {
		super();
		this.email = email;
		this.favArticles = favArticles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<articleModel> getFavArticles() {
		return favArticles;
	}
	public void setFavArticles(List<articleModel> favArticles) {
		this.favArticles = favArticles;
	}
	@Override
	public String toString() {
		return "userModel [email=" + email + ", favArticles=" + favArticles + "]";
	}
	
	
	

}
