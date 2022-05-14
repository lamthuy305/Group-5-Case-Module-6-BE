package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.RankBedroom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRankBedroomRepository extends PagingAndSortingRepository<RankBedroom, Long> {
}
