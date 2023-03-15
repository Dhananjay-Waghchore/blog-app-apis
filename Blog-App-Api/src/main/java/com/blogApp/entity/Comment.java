package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private String comment;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date commentDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
