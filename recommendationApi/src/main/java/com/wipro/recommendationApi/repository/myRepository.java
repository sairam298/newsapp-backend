package com.wipro.recommendationApi.repository;
import com.wipro.recommendationApi.model.userModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface myRepository extends MongoRepository<userModel, String> {

}
