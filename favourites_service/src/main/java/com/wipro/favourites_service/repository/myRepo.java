package com.wipro.favourites_service.repository;

import com.wipro.favourites_service.model.userModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface myRepo extends MongoRepository<userModel, String>{

}
