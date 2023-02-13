package com.example.blogapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.blogapp.payloads.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

	private String categorytitle;
	private String categorydescription;
	
	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getCategorytitle() {
		return categorytitle;
	}
	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public Category(String categorytitle, String categorydescription) {
		super();
		this.categorytitle = categorytitle;
		this.categorydescription = categorydescription;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy ="category",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
}
