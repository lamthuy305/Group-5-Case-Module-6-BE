package com.example.casemodule6.service.order;

import com.example.casemodule6.model.entity.Order;
import com.example.casemodule6.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IGeneralService<Order> {
    Page<Order> findOrderByName(String name);
}
