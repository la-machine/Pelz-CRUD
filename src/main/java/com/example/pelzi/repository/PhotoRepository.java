package com.example.pelzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pelzi.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
    
}
