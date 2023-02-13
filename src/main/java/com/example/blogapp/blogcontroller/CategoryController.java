package com.example.blogapp.blogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.blogservice.CategoryServiceImpl;
import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.CategoryDto;
import com.example.blogapp.payloads.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryservice;

	@PostMapping("/add")
	private ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categorydto){
		CategoryDto createdcategorydto = this.categoryservice.createCategory(categorydto);
	return new ResponseEntity<>(createdcategorydto,HttpStatus.CREATED);
} 
	@PutMapping("/{id}")
	private ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categorydto ,@PathVariable int id){
		CategoryDto updatedcategorydto = this.categoryservice.updateCategory(categorydto, id);
		return  ResponseEntity.ok(updatedcategorydto);
	}
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<ApiResponse> deleteCategory(@PathVariable int id){
		this.categoryservice.deleteCategory(id);
		return new ResponseEntity(new ApiResponse("category deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/categorylist")
	public ResponseEntity<List<CategoryDto>> getAllUser(){
		return ResponseEntity.ok(this.categoryservice.getAllCategory());
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDto> getUserById(@PathVariable int id){
		return ResponseEntity.ok(this.categoryservice.getCategoryById(id));
	}
	
}
