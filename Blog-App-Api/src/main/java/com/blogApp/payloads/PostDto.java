package com.blogApp.payloads;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.blogApp.entity.Category;
import com.blogApp.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

	private int postId;

	@NotNull
	@Size(min = 4, message = "Title must contain atleast four charecters")
	private String postTitle;

	@NotNull
	@Size(min = 4, message = "Post content should not be empty")
	@Column(length = 10000)
	private String postContent;

	private String postImage;

	private Date postDate;

	private CategoryDto category;

	private UserDto user;

	private String title;
}
