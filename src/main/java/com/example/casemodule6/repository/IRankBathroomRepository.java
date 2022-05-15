package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.RankBathroom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRankBathroomRepository extends PagingAndSortingRepository<RankBathroom, Long> {
}
