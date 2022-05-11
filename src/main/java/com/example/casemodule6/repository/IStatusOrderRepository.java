package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.StatusOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusOrderRepository extends PagingAndSortingRepository<StatusOrder, Long> {
}
