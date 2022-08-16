package com.wipro.favourites_service.service;

import java.util.List;

import com.wipro.favourites_service.model.articleModel;
import com.wipro.favourites_service.model.userModel;

public interface service {
	public userModel setFavourite(String email,articleModel favArticle);
	public List<articleModel> getFavourites(String email);
	public boolean deleteFavourite(String email,String url);
	

}
