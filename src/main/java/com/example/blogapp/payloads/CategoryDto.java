package com.example.blogapp.payloads;

public class CategoryDto {
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(int id, String categorytitle, String categorydescription) {
		super();
		this.id = id;
		this.categorytitle = categorytitle;
		this.categorydescription = categorydescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	private int id;
	private String categorytitle;
	private String categorydescription;
}
