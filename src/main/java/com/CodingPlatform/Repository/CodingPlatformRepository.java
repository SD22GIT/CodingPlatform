package com.CodingPlatform.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.CodingPlatform.Entity.User;

public interface CodingPlatformRepository extends MongoRepository<User, Integer> {
	

}
