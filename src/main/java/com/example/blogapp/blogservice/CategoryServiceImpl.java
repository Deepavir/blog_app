package com.example.blogapp.blogservice;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.blogexception.ResourceNotFoundException;
import com.example.blogapp.entity.Category;
import com.example.blogapp.entity.User;
import com.example.blogapp.payloads.CategoryDto;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private CategoryRepository categoryrepo;

	@Override
	public CategoryDto createCategory(CategoryDto categorydto) {
		Category category = this.dtoTocategory(categorydto);
		Category savedcategory = this.categoryrepo.save(category);
		return this.categorytodto(savedcategory);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, int id) {
		Category category = this.categoryrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryid", id));
		category.setCategorytitle(categorydto.getCategorytitle());
		category.setCategorydescription(categorydto.getCategorydescription());
		Category updatedcategory = this.categoryrepo.save(category);
		

		return this.categorytodto(updatedcategory);
		
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		Category category = this.categoryrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
		return this.categorytodto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryrepo.findAll();
		List<CategoryDto> categorydto = categories.stream().map(category -> this.categorytodto(category)).collect(Collectors.toList());
		return categorydto;
	}

	@Override
	public void deleteCategory(int id) {
		Category category = this.categoryrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "Id", id));

		this.categoryrepo.deleteById(id);
		
	}
public Category dtoTocategory(CategoryDto categorydto) {

		Category category = this.modelmapper.map(categorydto, Category.class);
		return category;
	}

	public CategoryDto categorytodto(Category category) {
		CategoryDto categorydto = this.modelmapper.map(category, CategoryDto.class);
		return categorydto;
	}
}
