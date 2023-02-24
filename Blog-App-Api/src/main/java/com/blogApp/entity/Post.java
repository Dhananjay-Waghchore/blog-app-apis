package com.blogApp.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name = "title")
	private String postTitle;
	
	@Column(name = "content")
	private String postContent;
	
	private String postImage;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date postDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	
	
	

}
