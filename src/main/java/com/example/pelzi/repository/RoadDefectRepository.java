package com.example.pelzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pelzi.model.RoadDefect;

@Repository
public interface RoadDefectRepository extends JpaRepository<RoadDefect, Long> {
    
}
