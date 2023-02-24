package com.blogApp.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
	
	@NotNull
	@Size(min = 4, message = "Title must contain atleast four charecters")
	private String postTitle;
	
	@NotNull
	@Size(min = 4, message = "Post content should not be empty")
	@Column(length = 10000)
	private String postContent;
	
	
}
