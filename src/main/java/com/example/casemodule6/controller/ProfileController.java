package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.ProfileForm;
import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.service.profile.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    IProfileService profileService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping
    public ResponseEntity<Iterable<Profile>> findAll() {
        Iterable<Profile> profiles = profileService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable Long id) {
        Profile profile = profileService.findByUserId(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @ModelAttribute ProfileForm profileForm) {
        Profile profile = profileService.findByUserId(id);
        MultipartFile imageFile = profileForm.getAvatar();
        String fileName = "";
        if (imageFile != null) {
            fileName = imageFile.getOriginalFilename();
            long currentTime = System.currentTimeMillis();
            fileName = currentTime + fileName;

            try {
                FileCopyUtils.copy(imageFile.getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            fileName = profile.getAvatar();
        }
        profile.setName(profileForm.getName());
        profile.setBirthday(profileForm.getBirthday());
        profile.setAvatar(fileName);
        profile.setEmail(profileForm.getEmail());
        profile.setAddress(profileForm.getAddress());
        profile.setPhone(profileForm.getPhone());
        profileService.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable Long id) {
        Optional<Profile> profileOptional = profileService.findById(id);
        if (!profileOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        profileService.removeById(id);
        return new ResponseEntity<>(profileOptional.get(), HttpStatus.OK);
    }
}
