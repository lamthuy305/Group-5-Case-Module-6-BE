package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.CommentForm;
import com.example.casemodule6.model.entity.*;
import com.example.casemodule6.service.comement.ICommentService;
import com.example.casemodule6.service.notificationdetail.INotificationDetailService;
import com.example.casemodule6.service.profile.IProfileService;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    IProfileService profileService;

    @Autowired
    private IUserService userService;

    @Autowired
    private INotificationDetailService notificationDetailService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> getAllCommentByHouseId(@RequestParam(name = "id") Long house_id) {
        return new ResponseEntity<>(commentService.getAllCommentByHouseId(house_id), HttpStatus.OK);
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<Iterable<Comment>> get5CommentByHouseId(@PathVariable Long id) {
        Iterable<Comment> comments = commentService.get5CommentByHouseId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentForm commentForm) {
        Comment comment = new Comment(commentForm.getText(), commentForm.getUser(), commentForm.getHouse(), commentForm.getProfile(), new Date(), 0L, 0L);
        Optional<User> userOptional = userService.findById(commentForm.getUser().getId());
        String path = "/view/" + commentForm.getHouse().getId();
        Profile profile = profileService.findByUserId(userOptional.get().getId());
        NotificationDetail notificationDetail = new NotificationDetail(new StatusNotification(4L), commentForm.getHouse(), new Date(), path, userOptional.get(),profile);
        notificationDetailService.save(notificationDetail);
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Comment> editComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(id);
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.removeById(id);
        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
    }
}
