package com.example.demo.com.by.repository;

import com.example.demo.com.by.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostory extends JpaRepository<User,String> {

}
