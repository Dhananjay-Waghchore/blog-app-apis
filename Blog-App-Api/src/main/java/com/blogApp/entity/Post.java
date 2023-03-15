package com.blogApp.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

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

	private String title;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();

}
