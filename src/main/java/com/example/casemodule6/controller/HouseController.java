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
    public ResponseEntity<Iterable<House>> findAllHouse(@RequestParam(name = "id") Optional<Long> id) {
        Iterable<House> houses = houseService.findAll();
        if (id.isPresent()) {
            houses = houseService.findAllByUserId(id.get());
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<Iterable<House>> find5HouseTopRent() {
        return new ResponseEntity<>(houseService.find5HouseTopRent(), HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<Iterable<House>> ramdom9House() {
        return new ResponseEntity<>(houseService.random9House(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<House>> getHouseSearchDone(@RequestParam(name = "city") Optional<String> city,
                                                              @RequestParam(name = "bedroom") Optional<String> bedroom,
                                                              @RequestParam(name = "bathroom") Optional<String> bathroom,
                                                              @RequestParam(name = "price") Optional<String> price,
                                                              @RequestParam(name = "type") Optional<String> type) {
        Iterable<House> houses = houseService.search9House(city.get(), bedroom.get(), bathroom.get(), price.get(), type.get());
        return new ResponseEntity<>(houses, HttpStatus.OK);
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
        String fileName = "";
        long currentTime = System.currentTimeMillis();
        if (img != null) {
            fileName = img.getOriginalFilename();
            fileName = currentTime + fileName;
            try {
                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            fileName = houseService.findById(houseForm.getId()).get().getImg();
        }
        House house = new House(houseForm.getId(), houseForm.getName(), houseForm.getArea(), houseForm.getCity(), houseForm.getLocation(), houseForm.getDescription(), houseForm.getBedroom(), houseForm.getBathroom(), houseForm.getPrice(),
                fileName, 0L, houseForm.getStatusHouse(), houseForm.getType(), houseForm.getUser(), houseService.checkRankBathroomOfHouse(houseForm.getBathroom()), houseService.checkRankBedroomOfHouse(houseForm.getBedroom()), houseService.checkRankPriceOfHouse(houseForm.getPrice()));
        houseService.save(house);

        if (houseForm.getImages() != null) {
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
            }
        }
        return new ResponseEntity<>(house, HttpStatus.CREATED);
    }


    @PostMapping("/img")
    public ResponseEntity<House> editImgHouse(@ModelAttribute HouseForm houseForm) {
        Optional<House> houseOptional = houseService.findById(houseForm.getId());
        MultipartFile img = houseForm.getImg();
        long currentTime = System.currentTimeMillis();
        String fileName = img.getOriginalFilename();
        fileName = currentTime + fileName;
        try {
            FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        houseOptional.get().setImg(fileName);
        houseService.save(houseOptional.get());
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
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
}

