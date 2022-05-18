package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.DislikeComment;
import com.example.casemodule6.model.entity.LikeComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikeCommentRepository extends PagingAndSortingRepository<LikeComment, Long> {
    @Query(value = "select * from like_comment where user_id = ?1 and comments_id =?2", nativeQuery = true)
    Optional<LikeComment> findByUserAndComment(Long user_id, Long comment_id);

}
