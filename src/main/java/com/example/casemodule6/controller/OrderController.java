package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.*;
import com.example.casemodule6.service.house.IHouseService;
import com.example.casemodule6.service.notificationdetail.INotificationDetailService;
import com.example.casemodule6.service.order.IOrderService;
import com.example.casemodule6.service.order.OrderService;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    INotificationDetailService notificationDetailService;

    @Autowired
    IHouseService houseService;

    @GetMapping("/processing/{currentUserId}")
    public ResponseEntity<Iterable<Order>> findAllOrderProcessingByUserId(@PathVariable Long currentUserId) {
        Iterable<Order> orders = orderService.findAllOrderProcessingByUserId(currentUserId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/changeStatusDone/{id}")
    public ResponseEntity<Order> changeStatusOrderDone(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderOptional.get().setStatusOrder(new StatusOrder(2L));
        return new ResponseEntity<>(orderService.save(orderOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/statusDone/{id}")
    public ResponseEntity<Iterable<Order>> findAllOrderStatusDone(@PathVariable Long id) {
        Iterable<Order> orders = orderService.findAllOrderStatusDone(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/historyOrderTop5/{id}")
    public ResponseEntity<Iterable<Order>> find5OrderByOrderIdRent(@PathVariable Long id) {
        Iterable<Order> orders = orderService.find5OrderByOrderIdRent(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/changeStatusCanceled/{id}") // Dùng khi admin hủy đơn
    public ResponseEntity<Order> changeStatusOrderCanceled(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderOptional.get().setStatusOrder(new StatusOrder(3L));
        return new ResponseEntity<>(orderService.save(orderOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/customerChangeStatusCanceled/{id}") //Dùng khi khách hàng hủy đơn ( tạo thông báo)
    public ResponseEntity<Order> customerChangeStatusOrderCanceled(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NotificationDetail notificationDetail = new NotificationDetail(new StatusNotification(2L), orderOptional.get().getHouse());
        notificationDetailService.save(notificationDetail);
        orderOptional.get().setStatusOrder(new StatusOrder(3L));
        return new ResponseEntity<>(orderService.save(orderOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/income")
    public ResponseEntity<Iterable<Order>> getHouseInMonthYear(@RequestParam(name = "id") Optional<String> id,
                                                               @RequestParam(name = "month") Optional<String> month,
                                                               @RequestParam(name = "year") Optional<String> year) {
        Iterable<Order> orders = orderService.getHouseInMonthYear(id.get(), month.get(), year.get());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<Iterable<Order>> getAllOrderByHouseId(@PathVariable Long id) {
        Iterable<Order> orders = orderService.getAllOrderByHouseId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Optional<House> houseOptional = houseService.findById(order.getHouse().getId());
        order.setStatusOrder(new StatusOrder(1L));
        NotificationDetail notificationDetail = new NotificationDetail(new StatusNotification(1L), houseOptional.get());
        notificationDetailService.save(notificationDetail);
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setId(id);
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.removeById(id);
        return new ResponseEntity<>(orderOptional.get(), HttpStatus.OK);
    }
}
