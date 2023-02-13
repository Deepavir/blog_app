package com.example.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogapp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
