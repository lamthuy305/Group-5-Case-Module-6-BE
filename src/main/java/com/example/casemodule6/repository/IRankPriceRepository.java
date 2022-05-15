package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.RankPrice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRankPriceRepository extends PagingAndSortingRepository<RankPrice, Long> {
}
