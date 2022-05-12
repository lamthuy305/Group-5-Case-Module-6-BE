package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.HouseForm;
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
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @Autowired
    private IImageService imageService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping
    public ResponseEntity<Iterable<House>> findAllHouse() {
        return new ResponseEntity<>(houseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<Iterable<House>> find5HouseTopRent() {
        return new ResponseEntity<>(houseService.find5HouseTopRent(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<House> findOne(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> save(@ModelAttribute HouseForm houseForm) {
        MultipartFile img = houseForm.getImg();
        String fileName = img.getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + fileName;
        try {
            FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        House house = new House(houseForm.getName(), houseForm.getArea(), houseForm.getLocation(), houseForm.getBedroom(), houseForm.getBathroom(), houseForm.getPrice(),
                fileName, 0L, houseForm.getStatusHouse(), houseForm.getType(), houseForm.getUser());

        houseService.save(house);

        List<MultipartFile> images = houseForm.getImages();
        if (images.size() > 0) {
            for (MultipartFile image : images) {
                fileName = image.getOriginalFilename();
                currentTime = System.currentTimeMillis();
                fileName = currentTime + fileName;
                try {
                    FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image imageHouse = new Image(fileName, house);
                imageService.save(imageHouse);
            }

            return new ResponseEntity<>(houseService.save(house), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<House> delete(@PathVariable Long id) {

        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Iterable<Image> images = imageService.findAllImageByHouseId(id);
        for (Image image : images) {
            imageService.removeById(image.getId());
        }
        houseService.removeById(id);
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<House> editHouse(@PathVariable Long id, @ModelAttribute House house) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        house.setId(id);
        return new ResponseEntity<House>(houseService.save(house), HttpStatus.OK);
    }
}
