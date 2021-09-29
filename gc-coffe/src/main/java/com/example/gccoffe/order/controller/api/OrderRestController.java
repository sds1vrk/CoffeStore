package com.example.gccoffe.order.controller.api;

import com.example.gccoffe.order.controller.CreateOrderRequest;
import com.example.gccoffe.order.model.Email;
import com.example.gccoffe.order.model.Order;
import com.example.gccoffe.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        return orderService.createOrder(
                // Email은 검증이 필요함으로 생성자를 이용하여 검증
                new Email(orderRequest.email()),
                orderRequest.address(),
                orderRequest.postcode(),
                orderRequest.orderItems()
        );
    }

}
