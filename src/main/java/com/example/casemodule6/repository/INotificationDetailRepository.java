package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.NotificationDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationDetailRepository extends PagingAndSortingRepository<NotificationDetail, Long> {
}
