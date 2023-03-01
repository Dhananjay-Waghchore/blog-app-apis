package com.blogApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogApp.payloads.PostDto;
import com.blogApp.payloads.PostResponse;

@Service
public interface PostService {

	// Create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update post
	PostDto updatePost(PostDto postDto, Integer postId);

	// Get post by Id
	PostDto getPostById(Integer postId);

	// Get all post
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

	// Get all posts by category
	List<PostDto> getAllPostsByCategory(Integer categoryId);

	// Get all posts by user
	List<PostDto> getAllPostsByUser(Integer userId);

	// Delete post
	public void deletepost(Integer postId);

	// Search posts by keyword
	List<PostDto> searchPosts(String keyWord);

}
