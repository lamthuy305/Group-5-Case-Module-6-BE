package com.example.casemodule6.service.likecomment;

import com.example.casemodule6.model.entity.LikeComment;
import com.example.casemodule6.service.IGeneralService;

import java.util.Optional;

public interface ILikeCommentService extends IGeneralService<LikeComment> {
    Optional<LikeComment> findByUserAndComment(Long user_id, Long comment_id);

}
