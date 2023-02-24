package com.blogApp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.entity.Category;
import com.blogApp.exceptions.ResourceNotFoundException;
import com.blogApp.payloads.CategoryDto;
import com.blogApp.repository.CategoryRepository;
import com.blogApp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Creating a new category
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.categoryDtoToCategory(categoryDto);
		Category savedCategory = this.categoryRepository.save(category);
		CategoryDto savedCategoryDto = this.categoryToCategoryDto(savedCategory);
		return savedCategoryDto;
	}

	// Updating existing category
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("category", "categoryId", categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = this.categoryRepository.save(category);
		return this.categoryToCategoryDto(updatedCategory);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		return this.categoryToCategoryDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryDto> categoryDto = categories.stream().map((category)-> 
						this.categoryToCategoryDto(category)).collect(Collectors.toList());
		return categoryDto;
	}	
	 

	@Override
	public void deleteCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryID", categoryId));
		this.categoryRepository.delete(category);
	}

	
	// category to categoryDto
	public CategoryDto categoryToCategoryDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	
	// categoryDto to category
	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		return category;
	}


}
