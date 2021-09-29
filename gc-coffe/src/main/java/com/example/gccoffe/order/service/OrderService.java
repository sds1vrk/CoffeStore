package com.example.gccoffe.order.service;

import com.example.gccoffe.order.model.Email;
import com.example.gccoffe.order.model.Order;
import com.example.gccoffe.order.model.OrderItem;

import java.util.List;

public interface OrderService {
    // ID는 자동으로 생성, Email, address, postcode, orderItems는 사용자로부터 받아야 함.
    Order createOrder(Email email,String address, String postcode, List<OrderItem> orderItems);
}
