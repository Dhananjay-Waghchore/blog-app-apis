package com.blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
