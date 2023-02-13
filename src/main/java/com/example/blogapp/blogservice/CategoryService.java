package com.example.blogapp.blogservice;

import java.util.List;

import com.example.blogapp.payloads.CategoryDto;



public interface CategoryService {

	
	CategoryDto createCategory(CategoryDto categortdto);
	CategoryDto updateCategory(CategoryDto categorydto,int id);
	CategoryDto getCategoryById(int id);
	List<CategoryDto> getAllCategory();
	void deleteCategory(int id);
	
}
