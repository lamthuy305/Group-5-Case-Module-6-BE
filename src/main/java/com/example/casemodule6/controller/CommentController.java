package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.CommentForm;
import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.comement.ICommentService;
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

    private IProfileService profileService;
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> getAllComment() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<Iterable<Comment>> getAllCommentByHouseId(@PathVariable Long id) {
        Iterable<Comment> comments = commentService.getAllCommentByHouseId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


//    @GetMapping("/like/{id}")
//    public ResponseEntity<Comment> setCountLike(@PathVariable Long id) {
//        Optional<Comment> commentOptional = commentService.findById(id);
//        Long currentLike = commentOptional.get().getCount_like();
//        commentOptional.get().setCount_like(currentLike + 1);
//        commentService.save(commentOptional.get());
//        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
//    }

//    @GetMapping("/dislike/{id}")
//    public ResponseEntity<Comment> setCountDislike(@PathVariable Long id) {
//        Optional<Comment> commentOptional = commentService.findById(id);
//        Long currentDislike = commentOptional.get().getCount_dislike();
//        commentOptional.get().setCount_dislike(currentDislike + 1);
//        commentService.save(commentOptional.get());
//        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
//    }

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
