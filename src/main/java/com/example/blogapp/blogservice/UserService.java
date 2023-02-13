package com.example.blogapp.blogservice;

import java.util.List;

import com.example.blogapp.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userdto);
	UserDto updateUser(UserDto userdto,int userId);
	UserDto getUserById(int id);
	List<UserDto> getAllUser();
	void deleteUser(int id);
}
