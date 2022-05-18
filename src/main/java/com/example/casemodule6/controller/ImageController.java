package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.ImageForm;
import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.service.house.IHouseService;
import com.example.casemodule6.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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


    @PostMapping("/{id}")
    public ResponseEntity<List<Image>> save(@PathVariable Long id, @ModelAttribute ImageForm imageForm) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<MultipartFile> images = imageForm.getImages();
        List<Image> imageList = new ArrayList<>();
        if (images.size() > 0) {
            for (MultipartFile image : images) {
                MultipartFile img = image;
                String fileName = img.getOriginalFilename();
                long currentTime = System.currentTimeMillis();
                fileName = currentTime + fileName;
                try {
                    FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image imageHouse = new Image(fileName, houseOptional.get());
                imageList.add(imageHouse);
                imageService.save(imageHouse);
            }
        }
        return new ResponseEntity<>(imageList, HttpStatus.CREATED);
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
