package com.blogApp.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private String comment;

    private Date commentDate;

    private UserDto user;

    private PostDto post;

}
