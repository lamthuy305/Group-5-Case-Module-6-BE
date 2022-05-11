package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.service.house.IHouseService;
import com.example.casemodule6.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private IImageService imageService;

    @Autowired
    private IHouseService houseService;


    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping("/house/{id}")
    public ResponseEntity<Iterable<Image>> findAllImageByHouseId(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Image> images = imageService.findAllImageByHouseId(id);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<Image> deleteImage(@PathVariable Long id) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.removeById(id);
        return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
    }

}
