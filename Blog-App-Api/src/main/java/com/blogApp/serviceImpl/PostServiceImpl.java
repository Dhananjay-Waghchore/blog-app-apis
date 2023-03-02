package com.blogApp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.blogApp.entity.Category;
import com.blogApp.entity.Post;
import com.blogApp.entity.User;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.payloads.PostDto;
import com.blogApp.payloads.PostResponse;
import com.blogApp.repository.CategoryRepository;
import com.blogApp.repository.PostRepository;
import com.blogApp.repository.UserRepository;
import com.blogApp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	// Create post
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		Post post = this.postDtoToPost(postDto);
		post.setPostImage("default.png");
		post.setPostDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		Post createdPost = this.postRepository.save(post);
		return this.postToPostDto(createdPost);
	}

	// Update post by id
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		post.setPostTitle(postDto.getPostTitle());
		post.setPostContent(postDto.getPostContent());

		PostDto updatedPostDto = this.postToPostDto(post);
		return updatedPostDto;
	}

	// Get post by id
	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		return this.postToPostDto(post);
	}

	// Get all posts
	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

		Pageable pegination = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<Post> pagePost = this.postRepository.findAll(pegination);
		List<Post> allPosts = pagePost.getContent();

		List<PostDto> postDto = allPosts.stream().map((post) -> this.postToPostDto(post)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	// Get all posts by category
	@Override
	public List<PostDto> getAllPostsByCategory(Integer categoryId) {

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		List<Post> posts = this.postRepository.findByCategory(category);
		List<PostDto> postDto = posts.stream().map((post) -> this.postToPostDto(post)).collect(Collectors.toList());

		return postDto;
	}

	// Get all posts by user
	@Override
	public List<PostDto> getAllPostsByUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

		List<Post> posts = this.postRepository.findByUser(user);
		List<PostDto> postDto = posts.stream().map((post) -> this.postToPostDto(post)).collect(Collectors.toList());
		return postDto;
	}

	// Search posts
	@Override
	public List<PostDto> searchPosts(String keyWord) {
		List<Post> searchedPost = this.postRepository.findByTitleContaining(keyWord);
		List<PostDto> searchedPostDto = searchedPost.stream().map((post)-> this.postToPostDto(post)).collect(Collectors.toList());
		return searchedPostDto;
	}

	// Delete post
	@Override
	public void deletepost(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
		this.postRepository.delete(post);
	}

	// Model Mapper to convert object postToPostDto
	public PostDto postToPostDto(Post post) {
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	}

	// Model Mapper to convert object postDtoToPost
	public Post postDtoToPost(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
		return post;
	}

}
