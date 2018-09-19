package com.example.demo.com.by.repository;

import com.example.demo.com.by.domain.MongoUser;
import com.example.demo.com.by.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser,String> {

}
