package com.blogApp.repository;

import com.blogApp.entity.Comment;
import com.blogApp.entity.Post;
import com.blogApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByUser(User user);

    List<Comment> findByPost(Post post);
}
