package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.DislikeComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDislikeCommentRepository extends PagingAndSortingRepository<DislikeComment, Long> {
    @Query(value = "select * from dislike_comment where user_id = ?1 and comments_id =?2", nativeQuery = true)
    Optional<DislikeComment> findByUserAndComment(Long user_id, Long comment_id);


}
