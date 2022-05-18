package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.StatusHouse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusHouseRepository extends PagingAndSortingRepository<StatusHouse, Long> {
}
