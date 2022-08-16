package com.wipro.favourites_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wipro.favourites_service.model.articleModel;
import com.wipro.favourites_service.model.userModel;
import com.wipro.favourites_service.repository.myRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceImpl implements service{
	
	@Autowired
	myRepo repo;
	
	userModel user;

	@Override
	public userModel setFavourite(String email,articleModel favArticle) {
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
	public List<articleModel> getFavourites(String email) {
//		// TODO Auto-generated method stub
		Optional<userModel> getUser= repo.findById(email);
		List<articleModel> li= getUser.get().getFavArticles();
		System.out.println(li);
		
		return li;
	}

	@Override
	public boolean deleteFavourite(String email, String url) {
		// TODO Auto-generated method stub
		Optional<userModel> getUser= repo.findById(email);
		List<articleModel> li= getUser.get().getFavArticles();
		for(int i=0;i<li.size();i++) {			
			if(li.get(i).getUrl().equals(url)) {
				li.remove(li.get(i));
				System.out.println(li);
				getUser.get().favArticles=li;
				System.out.println(getUser.get().getFavArticles());
				repo.save(getUser.get());
				return true;
			}
		}
		return false;
	}


}
