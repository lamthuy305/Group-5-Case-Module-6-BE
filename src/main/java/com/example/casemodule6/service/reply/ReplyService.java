package com.example.casemodule6.service.reply;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.Reply;
import com.example.casemodule6.repository.IReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReplyService implements IReplyService {
    @Autowired
    private IReplyRepository replyRepository;


    @Override
    public Iterable<Reply> findAll() {
        return replyRepository.findAll();
    }

    @Override
    public Optional<Reply> findById(Long id) {
        return replyRepository.findById(id);
    }

    @Override
    public Reply save(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public void removeById(Long id) {
        replyRepository.deleteById(id);

    }


    @Override
    public Iterable<Reply> get5ReplyByCommentId(Long id) {
        return replyRepository.get5ReplyByCommentId(id);
    }

    @Override
    public Iterable<Reply> getAllReplyByCommentId(Long id) {
        return replyRepository.getAllReplyByCommentId(id);
    }
}
