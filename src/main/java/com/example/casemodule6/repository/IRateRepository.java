package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Rate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRateRepository extends PagingAndSortingRepository<Rate, Long> {
    Iterable<Rate> findAllByHouseId(Long houseId);
}
