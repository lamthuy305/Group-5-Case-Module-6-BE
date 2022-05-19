package com.example.casemodule6.controller;

import com.example.casemodule6.model.dto.CommentForm;
import com.example.casemodule6.model.dto.ReplyForm;
import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.NotificationDetail;
import com.example.casemodule6.model.entity.Reply;
import com.example.casemodule6.model.entity.StatusNotification;
import com.example.casemodule6.service.notificationdetail.INotificationDetailService;
import com.example.casemodule6.service.reply.ReplyService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/replies")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
//
//    @Autowired
//    private INotificationDetailService notificationDetailService;


    @GetMapping
    public ResponseEntity<Iterable<Reply>> getAllReplyByCommentId(@RequestParam(name = "id") Long comment_id) {
        return new ResponseEntity<>(replyService.getAllReplyByCommentId(comment_id), HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Iterable<Reply>> get5CommentByHouseId(@PathVariable Long id) {
        Iterable<Reply> replies = replyService.get5ReplyByCommentId(id);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reply> getCommentById(@PathVariable Long id) {
        Optional<Reply> replyOptional = replyService.findById(id);
        if (!replyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(replyOptional.get(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Reply> createComment(@RequestBody ReplyForm replyForm) {
        Reply reply = new Reply(replyForm.getText(),replyForm.getComment(),replyForm.getUser(),replyForm.getProfile(), new Date(), 0L, 0L);
//        NotificationDetail notificationDetail = new NotificationDetail(new StatusNotification(4L), replyForm.getComment());
//        notificationDetailService.save(notificationDetail);
        return new ResponseEntity<>(replyService.save(reply), HttpStatus.CREATED);
    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Comment> editComment(@PathVariable Long id, @RequestBody Comment comment) {
//        Optional<Comment> commentOptional = commentService.findById(id);
//        if (!commentOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        comment.setId(id);
//        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
//        Optional<Comment> commentOptional = commentService.findById(id);
//        if (!commentOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        commentService.removeById(id);
//        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
//    }

}
