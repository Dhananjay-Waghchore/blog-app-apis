package com.blogApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.entity.Category;
import com.blogApp.entity.Post;
import com.blogApp.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
