package com.example.pelzi.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PhotoDto {
    // category attributes
    private String observation;
    // location attributes
    private String longitude;
    private String latitude;
    // photo attributes
    private String image;
    // roaddefect attributes
    private String surfaceArea;
    private String pressure;
    private String height;
}
