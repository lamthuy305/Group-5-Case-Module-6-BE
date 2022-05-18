package com.example.casemodule6.service.likecomment;

import com.example.casemodule6.model.entity.LikeComment;
import com.example.casemodule6.repository.ILikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeCommentService implements ILikeCommentService {
    @Autowired
    private ILikeCommentRepository likeCommentRepository;

    @Override
    public Iterable<LikeComment> findAll() {
        return likeCommentRepository.findAll();
    }

    @Override
    public Optional<LikeComment> findById(Long id) {
        return likeCommentRepository.findById(id);
    }

    @Override
    public LikeComment save(LikeComment likeComment) {
        return likeCommentRepository.save(likeComment);
    }

    @Override
    public void removeById(Long id) {
        likeCommentRepository.deleteById(id);
    }

    @Override
    public Optional<LikeComment> findByUserAndComment(Long user_id, Long comment_id) {
        return likeCommentRepository.findByUserAndComment(user_id, comment_id);
    }
}
