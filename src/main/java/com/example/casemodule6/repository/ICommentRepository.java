package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
