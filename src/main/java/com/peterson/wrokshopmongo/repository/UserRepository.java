package com.peterson.wrokshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.peterson.wrokshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
