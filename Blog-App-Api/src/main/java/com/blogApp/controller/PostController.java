package com.blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.payloads.ApiResponse;
import com.blogApp.payloads.PostDto;
import com.blogApp.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired(required = true)
	private PostService postService;
	
	//Create post API
	@PostMapping("/userId/{userId}/categoryId/{categoryId}/")
	public ResponseEntity<PostDto> createPost(@Valid 
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId){
		PostDto createdPostDto = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPostDto, HttpStatus.CREATED);
	}
	
	//Update post By Id API 
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPostDto, HttpStatus.OK);
	}
	
	//Get post By Id API
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.FOUND);
	}
	
	//Get all posts
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> postDto = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(postDto, HttpStatus.OK);
	}
	
	//Get all posts by category
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getByCategory(@PathVariable Integer categoryId){
		List<PostDto> postDto = this.postService.getAllPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDto, HttpStatus.OK);
	}
	
	//Get all posts by user
		@GetMapping("/user/{userId}")
		public ResponseEntity<List<PostDto>> getByUser(@PathVariable Integer userId){
			List<PostDto> postDto = this.postService.getAllPostsByUser(userId);
			return new ResponseEntity<List<PostDto>>(postDto, HttpStatus.OK);
		}
		
	
	//Delete post API
	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
		this.postService.deletepost(postId);
		return new ResponseEntity<ApiResponse>
			(new ApiResponse("Post deleted successfully", true), HttpStatus.OK);
 	}
		
}
