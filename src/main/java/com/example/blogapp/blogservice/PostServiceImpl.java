package com.example.blogapp.blogservice;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.blogexception.ResourceNotFoundException;
import com.example.blogapp.entity.Post;
import com.example.blogapp.payloads.PostDto;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.repository.CategoryRepository;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.entity.User;
import com.example.blogapp.entity.Category;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postrepo;
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CategoryRepository categoryrepo;

	@Override
	public PostDto createPost(PostDto postdto ,int userid,int categoryid) {
		User user = this.userrepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userid));
		Category category = this.categoryrepo.findById(categoryid).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryid));
		Post post = this.modelmapper.map(postdto, Post.class);
		post.setImagename("default.png");
		post.setAddeddate(new Date());
		post.setUser(user);
		post.setCategory(category);
		this.postrepo.save(post);
		return this.modelmapper.map(post, PostDto.class);
	}

	@Override
	public Post UpdatePost(PostDto postdto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(int categoryid) {
	Category category = this.categoryrepo.findById(categoryid).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryid));
		List<Post> postslist = this.postrepo.findByCategory(category);
		
		List<PostDto> postdto = postslist.stream().map((posts)-> this.modelmapper.map(posts,PostDto.class)).collect(Collectors.toList());
		return postdto;
	}

	@Override
	public List<PostDto> getPostByUser(int id) {
		User user = this.userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "userId", id));
		List<Post> postslist = this.postrepo.findByUser(user);
		
		List<PostDto> postdto = postslist.stream().map((posts)-> this.modelmapper.map(posts,PostDto.class)).collect(Collectors.toList());
		return postdto;
	}
	

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
