package com.example.casemodule6.service.dislikecomment;

import com.example.casemodule6.model.entity.DislikeComment;
import com.example.casemodule6.service.IGeneralService;

import java.util.Optional;

public interface IDislikeCommentService extends IGeneralService<DislikeComment> {
    Optional<DislikeComment> findByUserAndComment(Long user_id, Long comment_id);

}