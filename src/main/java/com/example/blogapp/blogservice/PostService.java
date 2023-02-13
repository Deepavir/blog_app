package com.example.blogapp.blogservice;

import java.util.List;

import com.example.blogapp.entity.Post;
import com.example.blogapp.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postdto,int userid , int categoryid);
	Post UpdatePost(PostDto postdto,int id);
	void deletePost(int id);
	List<Post> getAllPost();
	Post getPostById(int id);
	//get post by category 
	List<PostDto> getPostByCategory(int categoryid);
	//get post by user
	List<PostDto> getPostByUser(int id);
	//search post by keyword
	List<Post> searchPost(String keyword);
	
}
