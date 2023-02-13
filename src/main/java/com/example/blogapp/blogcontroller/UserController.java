package com.example.blogapp.blogcontroller;

import java.util.List;
import java.util.Map;

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

import com.example.blogapp.blogservice.UserServiceImpl;
import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceImpl userservice;
	
	@PostMapping("/add")
	private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto){
	UserDto createduserdto = this.userservice.createUser(userdto);
	return new ResponseEntity<>(createduserdto,HttpStatus.CREATED);
} 
	@PutMapping("/{id}")
	private ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userdto ,@PathVariable int id){
		UserDto updateduserdto = this.userservice.updateUser(userdto, id);
		return  ResponseEntity.ok(updateduserdto);
	}
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable int id){
		this.userservice.deleteUser(id);
		return new ResponseEntity(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userservice.getAllUser());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id){
		return ResponseEntity.ok(this.userservice.getUserById(id));
	}
	
	
	
	
}