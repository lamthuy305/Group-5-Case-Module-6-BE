package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.JwtResponse;
import com.example.casemodule6.model.dto.SignUpForm;
import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.JwtService;
import com.example.casemodule6.service.profile.IProfileService;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IProfileService profileService;


    @Value("${file-upload}")
    private String uploadPath;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody SignUpForm signUpForm, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!signUpForm.getPasswordForm().getPassword().equals(signUpForm.getPasswordForm().getConfirmPassword()) || !userService.checkRegexPassword(signUpForm.getPasswordForm().getPassword()) ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpForm.getUsername(), signUpForm.getPasswordForm().getPassword(), signUpForm.getRoles());
        Profile profile = new Profile(signUpForm.getPhone(), user);
        profileService.save(profile);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

}
