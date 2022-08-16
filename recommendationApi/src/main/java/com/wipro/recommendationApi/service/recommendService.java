package com.wipro.recommendationApi.service;

import java.util.List;

import com.wipro.recommendationApi.model.articleModel;
import com.wipro.recommendationApi.model.userModel;


public interface recommendService {
	public userModel setRefer(String email,articleModel favArticle);
	public List<articleModel> getRefers(String email);
	

}
