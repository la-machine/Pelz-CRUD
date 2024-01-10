package com.example.pelzi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoadDefect {
    @Id
    @GeneratedValue
    private Long id;
    private String surfaceArea;
    private String pressure;
    private String height;
    @OneToOne
    private Photo photo;
}
