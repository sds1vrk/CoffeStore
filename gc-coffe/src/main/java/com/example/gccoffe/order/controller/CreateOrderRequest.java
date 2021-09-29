package com.example.gccoffe.order.controller;

import com.example.gccoffe.order.model.OrderItem;

import java.util.List;

public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {
}
