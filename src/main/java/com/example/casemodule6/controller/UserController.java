package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        Iterable<User> users = userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<User> checkUserBan(@RequestBody User user) {
        Iterable<User> users = userService.findAllUser();
        for (User user1 : users) {
            if (user1.getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(user1, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> banUser(@PathVariable Long id) {
//        Optional<User> user = userService.findById(id);
//        if (!user.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        if (user.get().isActive()) {
//            user.get().setActive(false);
//            return new ResponseEntity<>(userService.save(user.get()), HttpStatus.OK);
//        } else {
//            user.get().setActive(true);
//            return new ResponseEntity<>(userService.save(user.get()), HttpStatus.OK);
//        }
//    }

}
