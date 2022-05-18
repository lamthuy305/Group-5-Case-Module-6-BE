package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.NotificationDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationDetailRepository extends PagingAndSortingRepository<NotificationDetail, Long> {
    @Query(value = "select * from notification_detail join houses h on notification_detail.house_id = h.id where user_id = ?1", nativeQuery = true)
    Iterable<NotificationDetail> getAllNotificationDetailByIdUser(Long id);


}
