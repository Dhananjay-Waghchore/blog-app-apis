package com.blogApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.entity.User;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.payloads.UserDto;
import com.blogApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	// Creating User
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		return this.userToUserDto(savedUser);
	}

	// Update existing user
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				    .orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		UserDto updatedUser = this.userToUserDto(user);
		return updatedUser;
	}

	// Retrieve user by userId
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				    .orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		
		return this.userToUserDto(user);
	}

	// Retrieving all users
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	
	//Deleting user by userId
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		this.userRepository.delete(user);
	}

	
	// Converting User to UserDto
	public UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;	
	}
	
	// Converting UserDto to User
	public User userDtoToUser(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;	
	}
	
	
	
}
