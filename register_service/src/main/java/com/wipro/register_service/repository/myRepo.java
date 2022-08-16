package com.wipro.register_service.repository;

import com.wipro.register_service.user.userDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface myRepo extends JpaRepository<userDetails, String> {
	
	

}
