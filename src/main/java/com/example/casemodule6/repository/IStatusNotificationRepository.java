package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.StatusNotification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusNotificationRepository extends PagingAndSortingRepository<StatusNotification, Long> {
}
