package com.blogApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogApp.payloads.CategoryDto;

@Service
public interface CategoryService {

	//Create Category 
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update Category
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//Get Category By Id
	CategoryDto getCategoryById(Integer CategoryId);
	
	//Get all Categories
	List<CategoryDto> getAllCategory();
	
	//Delete CAtegory by Id
	void deleteCategoryById(Integer categoryId);
	
}
