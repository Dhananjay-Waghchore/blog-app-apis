package com.blogApp.service;

import com.blogApp.payloads.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    // Create comment
    CommentDto createComment(CommentDto commentDto, Integer postId);

    // Update comment
    CommentDto updateComment(Integer commentId);

    // Get Comment by id
    CommentDto getCommentById(Integer commentId);

    // Get all comments
    List<CommentDto> getAllComments();

    // Get comment by user
    List<CommentDto> getCommentsByUser(Integer userId);

    // Get comment by post
    List<CommentDto> getCommentByPost(Integer postId);

    // Delete comment
    void deleteComment(Integer commentId);


}
