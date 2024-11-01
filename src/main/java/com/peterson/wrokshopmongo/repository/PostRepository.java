package com.peterson.wrokshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peterson.wrokshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
