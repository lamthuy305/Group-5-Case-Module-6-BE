package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.DislikeComment;
import com.example.casemodule6.model.entity.LikeComment;
import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.comment.ICommentService;
import com.example.casemodule6.service.dislikecomment.IDislikeCommentService;
import com.example.casemodule6.service.likecomment.ILikeCommentService;
import com.example.casemodule6.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/likeComment")
public class LikeCommentController {

    @Autowired
    private IDislikeCommentService dislikeCommentService;
    @Autowired
    private ILikeCommentService likeCommentService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("/like/{id}")
    public ResponseEntity<DislikeComment> likeComment(@PathVariable Long id, @RequestParam(name = "user") Long user_id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        Long dislikeCurrent = commentOptional.get().getCount_dislike();
        Long likeCurrent = commentOptional.get().getCount_like();
        Optional<User> userOptional = userService.findById(user_id);
        Optional<LikeComment> likeCommentOptional = likeCommentService.findByUserAndComment(user_id, id);
        Optional<DislikeComment> dislikeCommentOptional = dislikeCommentService.findByUserAndComment(user_id, id);

        if (likeCommentOptional.isPresent()) {
            likeCommentService.removeById(likeCommentOptional.get().getId());
            commentOptional.get().setCount_like(likeCurrent - 1);
            commentService.save(commentOptional.get());
        } else {
            if (dislikeCommentOptional.isPresent()) {
                dislikeCommentService.removeById(dislikeCommentOptional.get().getId());
                commentOptional.get().setCount_dislike(dislikeCurrent - 1);
                commentService.save(commentOptional.get());
            }
            LikeComment likeComment = new LikeComment(commentOptional.get(), userOptional.get());
            likeCommentService.save(likeComment);
            commentOptional.get().setCount_like(likeCurrent + 1);
            commentService.save(commentOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
