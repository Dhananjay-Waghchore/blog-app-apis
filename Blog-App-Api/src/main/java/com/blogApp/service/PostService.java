package com.blogApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogApp.payloads.PostDto;

@Service
public interface PostService {

	//Create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//Update post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Get post by Id
	PostDto getPostById(Integer postId);
	
	//Get all post
	List<PostDto> getAllPost();
	
	//Delete post
	public void deletepost(Integer postId);
	
	//Get all posts by category
	List<PostDto> getAllPostsByCategory(Integer categoryId);
	
	//Get all posts by user
	List<PostDto> getAllPostsByUser(Integer userId);
	
	//Search posts by keyword
	List<PostDto> searchPosts(String keyWord);
	
}
