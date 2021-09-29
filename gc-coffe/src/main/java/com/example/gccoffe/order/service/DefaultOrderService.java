package com.example.gccoffe.order.service;

import com.example.gccoffe.order.model.Email;
import com.example.gccoffe.order.model.Order;
import com.example.gccoffe.order.model.OrderItem;
import com.example.gccoffe.order.model.OrderStatus;
import com.example.gccoffe.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultOrderService implements OrderService {
    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems) {
        Order order=new Order(
                UUID.randomUUID(),
                email,
                address,
                postcode,
                orderItems,
                OrderStatus.ACCEPTED,
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        return orderRepository.insert(order);

    }
}
