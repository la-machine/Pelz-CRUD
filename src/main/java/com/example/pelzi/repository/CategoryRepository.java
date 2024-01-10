package com.example.pelzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pelzi.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
