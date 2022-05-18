package com.example.casemodule6.service.comement;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.service.IGeneralService;

public interface ICommentService extends IGeneralService<Comment> {
    Iterable<Comment> get5CommentByHouseId(Long id);

    Iterable<Comment> getAllCommentByHouseId(Long id);

}
