package com.blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
