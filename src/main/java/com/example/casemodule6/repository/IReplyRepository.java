package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.Reply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReplyRepository extends PagingAndSortingRepository<Reply, Long> {
    @Query(value = "select * from reply where comment_id = ?1 order by create_time DESC limit 5", nativeQuery = true)
    Iterable<Reply> get5ReplyByCommentId(Long id);

    @Query(value = "select * from reply where comment_id = ?1 order by create_time DESC", nativeQuery = true)
    Iterable<Reply> getAllReplyByCommentId(Long id);


}
