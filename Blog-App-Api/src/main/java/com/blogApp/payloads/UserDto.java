package com.blogApp.payloads;

import lombok.Data;

@Data
public class UserDto {

	private int userId;
	private String userName;
	private String email;
	private String password;
	private String about;
	
}
