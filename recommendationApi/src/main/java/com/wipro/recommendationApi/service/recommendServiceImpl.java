package com.wipro.recommendationApi.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wipro.recommendationApi.model.articleModel;
import com.wipro.recommendationApi.model.userModel;
import com.wipro.recommendationApi.repository.myRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class recommendServiceImpl implements recommendService{
	
	@Autowired
	myRepository repo;
	
	userModel user;

	@Override
	public userModel setRefer(String email,articleModel favArticle) {
		// TODO Auto-generated method stub
		List<articleModel> li=new ArrayList<articleModel>();
		Optional<userModel> getUser=repo.findById(email);
		System.out.println(getUser);
		if(!getUser.isPresent()) {
			li.add(favArticle);
			user=new userModel(email,li);

			repo.save(user);
			return user;
		}
		else {
			boolean flag=true;
			System.out.println(getUser);
			for(int i=0;i<getUser.get().favArticles.size();i++) {
				if(getUser.get().favArticles.get(i).getUrl().equals(favArticle.getUrl())){
					flag=false;
				}
			}
			if(flag==true) {
			getUser.get().favArticles.add(favArticle);
			repo.save(getUser.get());
			}
			return user;
		}
	}

	@Override
	public List<articleModel> getRefers(String email) {
//		// TODO Auto-generated method stub
		Optional<userModel> getUser= repo.findById(email);
		List<articleModel> li= getUser.get().getFavArticles();
		System.out.println(li);
		
		return li;
	}

	


}
