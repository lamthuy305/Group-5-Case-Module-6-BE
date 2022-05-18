package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {

    @Query(value = "select * from comment where house_id = ?1 order by create_time DESC limit 5", nativeQuery = true)
    Iterable<Comment> get5CommentByHouseId(Long id);

    @Query(value = "select * from comment where house_id = ?1 order by create_time DESC", nativeQuery = true)
    Iterable<Comment> getAllCommentByHouseId(Long id);
}