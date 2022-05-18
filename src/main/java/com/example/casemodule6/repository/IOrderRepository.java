package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<Order, Long> {
    @Query(value = "select * from orders join houses h on orders.house_id = h.id where status_order_id =1 AND h.user_id =?1", nativeQuery = true)
    Iterable<Order> findAllOrderProcessingByUserId(Long user_id);

    @Query(value = "select * from orders join houses h on orders.house_id = h.id where status_order_id =2 AND h.user_id =?1", nativeQuery = true)
    Iterable<Order> findAllOrderStatusDone(Long user_id);

    @Query(value = "select * from orders where house_id = ?1 and status_order_id = 2", nativeQuery = true)
    Iterable<Order> getAllOrderByHouseId(Long id);

    @Query(value = "select * from orders where user_id = ?1 order by check_out DESC limit 5", nativeQuery = true)
    Iterable<Order> find5OrderByOrderIdRent(Long user_id);

    @Query(value = "call in_come_house(?1,?2,?3)", nativeQuery = true)
    Iterable<Order> getHouseInMonthYear(String id, String month, String year);
}
