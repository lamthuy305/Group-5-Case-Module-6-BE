package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.ChangePasswordForm;
import com.example.casemodule6.model.dto.JwtResponse;
import com.example.casemodule6.model.dto.SignUpForm;
import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.JwtService;
import com.example.casemodule6.service.profile.IProfileService;
import com.example.casemodule6.service.user.IUserService;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNotFoundEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;


@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private JwtService jwtService;


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
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername() ,userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody SignUpForm signUpForm, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!signUpForm.getPasswordForm().getPassword().equals(signUpForm.getPasswordForm().getConfirmPassword()) || !userService.checkRegexPassword(signUpForm.getPasswordForm().getPassword()) || !userService.checkRegexPassword(signUpForm.getPasswordForm().getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = new User(signUpForm.getUsername().toLowerCase(Locale.ROOT), signUpForm.getNumberPhone(), signUpForm.getPasswordForm().getPassword(), signUpForm.getRoles(), true);
        userService.save(user);
        User userCurrent = userService.findByUsername(signUpForm.getUsername());
        Profile profile = new Profile("avatar.jpg",signUpForm.getNumberPhone(), userCurrent);
        profileService.save(profile);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @PutMapping("/changePassword")
    public ResponseEntity<User> changePassword(@Valid @RequestBody ChangePasswordForm changePasswordForm, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(changePasswordForm.getUsername(), changePasswordForm.getCurrentPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userService.findByUsername(changePasswordForm.getUsername());
        if (changePasswordForm.getCurrentPassword().equals(changePasswordForm.getPasswordForm().getPassword())||!changePasswordForm.getPasswordForm().getPassword().equals(changePasswordForm.getPasswordForm().getConfirmPassword())||!userService.checkRegexPassword(changePasswordForm.getPasswordForm().getPassword()) || !userService.checkRegexPassword(changePasswordForm.getPasswordForm().getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(changePasswordForm.getPasswordForm().getConfirmPassword());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }






}
