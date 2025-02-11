package com.blogger.services.impl;

import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.entity.Category;
import com.blogger.exceptions.ResourceNotFoundException;
import com.blogger.payloads.CategoryDto;
import com.blogger.repositories.CategoryRepo;
import com.blogger.services.CategoryService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//create
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}
	
	//update
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat =this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "category Id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
	
		Category updatedCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}
	
	
	//delete
	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "category Id", categoryId));
		this.categoryRepo.delete(cat);

	}
	
	//getbyid
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	//getall
	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
					return catDtos;

	}

}
