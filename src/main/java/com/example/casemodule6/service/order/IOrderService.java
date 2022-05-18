package com.example.casemodule6.service.order;

import com.example.casemodule6.model.entity.Order;
import com.example.casemodule6.service.IGeneralService;
import org.springframework.data.domain.Page;

public interface IOrderService extends IGeneralService<Order> {
    Page<Order> findOrderByName(String name);

    Iterable<Order> findAllOrderProcessingByUserId(Long user_id);

    Iterable<Order> findAllOrderStatusDone(Long user_id);

    Iterable<Order> getAllOrderStatusDoneByIdHouse(Long house_id);

    Iterable<Order> find5OrderByOrderIdRent(Long user_id);

    Iterable<Order> getAllOrderByHouseId(Long id);

    Iterable<Order> getHouseInMonthYear(String id, String month, String year);
}
