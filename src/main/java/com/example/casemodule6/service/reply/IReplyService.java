package com.example.casemodule6.service.reply;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.Reply;
import com.example.casemodule6.service.IGeneralService;

public interface IReplyService extends IGeneralService<Reply> {
    Iterable<Reply> get5ReplyByCommentId(Long id);

    Iterable<Reply> getAllReplyByCommentId(Long id);



}
