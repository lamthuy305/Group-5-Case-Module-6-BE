package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Image;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {
}
