package com.example.casemodule6.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
//    @Autowired
//    private IImageService imageService;


//    @Value("${file-upload}")
//    private String uploadPath;
//
//    @GetMapping
//    public ResponseEntity<Iterable<Image>> findAllImage(@RequestParam Optional<Long> id) {
//        Iterable<Image> images = imageService.findAll();
//        if (id.isPresent()) {
////            images = imageService.findImageByHouseId(id.get());
//        }
//        return new ResponseEntity<>(images, HttpStatus.OK);
//    }
//
//
//    @PostMapping("/{id}")
//    public ResponseEntity<List<Image>> save(@PathVariable Optional<Long> id, @ModelAttribute ImageForm imageForm) {
//        Optional<House> house = imageService.findById(id.get());
//        if (!house.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        List<MultipartFile> images = imageForm.getImages();
//        List<Image> imageList = new ArrayList<>();
//        if (images.size() > 0) {
//            for (MultipartFile image : images) {
//                MultipartFile img = image;
//                String fileName = img.getOriginalFilename();
//                long currentTime = System.currentTimeMillis();
//                fileName = currentTime + fileName;
//                try {
//                    FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Image imageFood = new Image(fileName, food.get());
//                imageList.add(imageFood);
//                imageService.save(imageFood);
//            }
//        }
//        return new ResponseEntity<>(imageList, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Image> deleteImage(@PathVariable Long id) {
//        Optional<Image> imageOptional = imageService.findById(id);
//        if (!imageOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        imageService.removeById(id);
//        return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
//    }

}
