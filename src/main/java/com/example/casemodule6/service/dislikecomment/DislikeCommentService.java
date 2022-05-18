package com.example.casemodule6.service.dislikecomment;

import com.example.casemodule6.model.entity.DislikeComment;
import com.example.casemodule6.repository.IDislikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DislikeCommentService implements IDislikeCommentService {
    @Autowired
    private IDislikeCommentRepository dislikeCommentRepository;

    @Override
    public Iterable<DislikeComment> findAll() {
        return dislikeCommentRepository.findAll();
    }

    @Override
    public Optional<DislikeComment> findById(Long id) {
        return dislikeCommentRepository.findById(id);
    }

    @Override
    public DislikeComment save(DislikeComment dislikeComment) {
        return dislikeCommentRepository.save(dislikeComment);
    }

    @Override
    public void removeById(Long id) {
        dislikeCommentRepository.deleteById(id);
    }

    @Override
    public Optional<DislikeComment> findByUserAndComment(Long user_id, Long comment_id) {
        return dislikeCommentRepository.findByUserAndComment(user_id, comment_id);
    }
}
