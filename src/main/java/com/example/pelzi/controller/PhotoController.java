package com.example.pelzi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pelzi.Dto.PhotoDto;
import com.example.pelzi.service.PhotoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping("add")
    public ResponseEntity<?> save(@RequestBody PhotoDto photo){
        return photoService.savePhoto(photo);
    }
}
