package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Rate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRateRepository extends PagingAndSortingRepository<Rate, Long> {
    Iterable<Rate> findAllByHouseId(Long houseId);

    @Query(value = "select avg(rates.star) from rates where house_id = ?", nativeQuery = true)
    double showTotalRateByHouseId(Long houseId);

    @Query(value = "select * from rates where user_id = ?1 and house_id = ?2", nativeQuery = true)
    Optional<Rate> findRateByUserIdAndHouId(Long user_id, Long house_id);


}
