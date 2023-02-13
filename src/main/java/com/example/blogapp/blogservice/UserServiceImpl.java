package com.example.blogapp.blogservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.blogexception.ResourceNotFoundException;
import com.example.blogapp.entity.User;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user = this.dtoToUser(userdto);
		User saveduser = this.userrepo.save(user);
		return this.usertodto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, int userId) {
		User user = this.userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updateduser = this.userrepo.save(user);

		return this.usertodto(updateduser);
	}

	@Override
	public UserDto getUserById(int id) {
		User user = this.userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "userId", id));
		return this.usertodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userrepo.findAll();
	
		List<UserDto> userdto = users.stream().map(user -> this.usertodto(user)).collect(Collectors.toList());
		return userdto;
	}

	@Override
	public void deleteUser(int id) {
		User user = this.userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "userId", id));

		this.userrepo.deleteById(id);
	}

	public User dtoToUser(UserDto userdto) {

		User user = this.modelmapper.map(userdto, User.class);
		return user;
	}

	public UserDto usertodto(User user) {
		UserDto userdto = this.modelmapper.map(user, UserDto.class);
		return userdto;
	}
}
