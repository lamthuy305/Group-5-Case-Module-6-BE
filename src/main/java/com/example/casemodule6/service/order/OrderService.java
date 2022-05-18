package com.example.casemodule6.service.order;

import com.example.casemodule6.model.entity.Order;
import com.example.casemodule6.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderRepository orderRepository;


    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void removeById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Page<Order> findOrderByName(String name) {
        return null;
    }

    @Override
    public Iterable<Order> findAllOrderProcessingByUserId(Long user_id) {
        return orderRepository.findAllOrderProcessingByUserId(user_id);
    }

    @Override
    public Iterable<Order> findAllOrderStatusDone(Long user_id) {
        return orderRepository.findAllOrderStatusDone(user_id);
    }

    @Override
    public Iterable<Order> find5OrderByOrderIdRent(Long user_id) {
        return orderRepository.find5OrderByOrderIdRent(user_id);
    }

    @Override
    public Iterable<Order> getAllOrderByHouseId(Long id) {
        return orderRepository.getAllOrderByHouseId(id);
    }


    @Override
    public Iterable<Order> getHouseInMonthYear(String id, String month, String year) {
        if (month == "") {
            month = "%%";
        }
        if (year == "") {
            year = "%%";
        }
        return orderRepository.getHouseInMonthYear(id,month, year);
    }
}
