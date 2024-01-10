package com.example.pelzi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pelzi.Dto.PhotoDto;
import com.example.pelzi.model.Category;
import com.example.pelzi.model.Location;
import com.example.pelzi.model.Photo;
import com.example.pelzi.model.RoadDefect;
import com.example.pelzi.repository.CategoryRepository;
import com.example.pelzi.repository.LocationRepository;
import com.example.pelzi.repository.PhotoRepository;
import com.example.pelzi.repository.RoadDefectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final RoadDefectRepository roadDefectRepository;

    public ResponseEntity<?> savePhoto(PhotoDto photo){
        // building object
        Category category = Category.builder().observation(photo.getObservation()).build();
        categoryRepository.save(category);
        Location locate = Location.builder().latitude(photo.getLatitude()).longitude(photo.getLongitude()).build();
        locationRepository.save(locate);
        Photo pic = Photo.builder().image(photo.getImage()).location(locate).category(category).build();
        photoRepository.save(pic);
        RoadDefect raod = RoadDefect.builder().surfaceArea(photo.getSurfaceArea()).pressure(photo.getPressure()).height(photo.getHeight()).build();
        roadDefectRepository.save(raod);
        return ResponseEntity.ok().body("Photo saved ...");
    }
}
