package com.example.pelzi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String observation;
    @Enumerated(EnumType.STRING)
    private TypeReseau reseau;
    @Enumerated(EnumType.STRING)
    private ReseauHD hydrolic;
    @OneToMany
    private List<Photo> photos;
}
