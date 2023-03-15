package com.blogApp.controller;

import com.blogApp.payloads.ApiResponse;
import com.blogApp.payloads.CommentDto;
import com.blogApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}")
    ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
        CommentDto createdCommentDto = this.commentService.createComment(commentDto,postId);
        return new ResponseEntity<CommentDto>(createdCommentDto, HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
    }



}
