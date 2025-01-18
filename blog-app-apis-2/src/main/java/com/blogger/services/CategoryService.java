package com.blogger.services;

import java.util.List;

import com.blogger.payloads.CategoryDto;

public interface CategoryService {
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

	// delete
	public void deleteCategory(Integer categoryId);
	
	// get
	 CategoryDto getCategory(Integer categoryId);
	 
	// getAll
	 List<CategoryDto> getCategories();
	 
}
