package com.blogApp.serviceImpl;

import com.blogApp.entity.Comment;
import com.blogApp.entity.Post;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.payloads.CommentDto;
import com.blogApp.repository.CommentRepository;
import com.blogApp.repository.PostRepository;
import com.blogApp.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post","postId",postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        Comment createdComment = this.commentRepository.save(comment);
        CommentDto createdCommentDto = this.modelMapper.map(createdComment, CommentDto.class);
        return createdCommentDto;
    }

    @Override
    public CommentDto updateComment(Integer commentId) {
        return null;
    }

    @Override
    public CommentDto getCommentById(Integer commentId) {
        return null;
    }

    @Override
    public List<CommentDto> getAllComments() {
        return null;
    }

    @Override
    public List<CommentDto> getCommentsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<CommentDto> getCommentByPost(Integer postId) {
        return null;
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()->
                new ResourceNotFoundException("Comment","commentId",commentId));
        this.commentRepository.delete(comment);
    }
}
