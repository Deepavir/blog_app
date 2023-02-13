package com.example.blogapp.blogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.blogservice.PostServiceImpl;
import com.example.blogapp.payloads.PostDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/get")
public class PostController {
	
	@Autowired
	private PostServiceImpl postservice;

	@PostMapping("/user/{userid}/category/{categoryid}/post")
	private ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postdto ,
			@PathVariable int userid,@PathVariable int categoryid){
		PostDto createdpostdto = this.postservice.createPost(postdto, userid, categoryid);
	return new ResponseEntity<>(createdpostdto,HttpStatus.CREATED);
} 
	
	//getbyuser
	@GetMapping("/user/{id}/post")
	private ResponseEntity<List<PostDto>> getPostByUsers(@PathVariable int id){
		List <PostDto> postdto = this.postservice.getPostByUser(id);
		System.out.println("list returned" +postdto);
		return new ResponseEntity<List<PostDto>>(postdto,HttpStatus.OK);
	}
	@GetMapping("/category/{id}/post")
	private ResponseEntity<List<PostDto>> getPostByCategorys(@PathVariable int id){
		List <PostDto> postdto = this.postservice.getPostByCategory(id);
		return new ResponseEntity<List<PostDto>>(postdto,HttpStatus.OK);
	}
}
