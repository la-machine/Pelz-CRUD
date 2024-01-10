package com.example.pelzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pelzi.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
    
}
