package com.example.gccoffe.order.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    // Email은 validation 필요 -> 따로 클래스 만들어서 사용
    private final Email email;
    private String address;
    private String postcode;

    // Item을 정보 모을수 있는 정보, 발송한 정보들은 수정 불가 (final)로 지정
    private final List<OrderItem> orderItems;
    // 현재 주문 상태 > Enum
    private OrderStatus orderStatus;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public Order(UUID orderId, Email email, String address, String postcode, List<OrderItem> orderItem, OrderStatus orderStatus, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.orderItems = orderItem;
        this.orderStatus = orderStatus;
        this.createdAt=createdAt;
        this.updatedAt = updatedAt;

    }

    public UUID getOrderId() {
        return orderId;
    }

    public Email getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    // 상품의 변경이 있을때마다 updatedAt을 최신화
    public void setAddress(String address) {
        this.address = address;
        this.updatedAt=LocalDateTime.now();
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
        this.updatedAt=LocalDateTime.now();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        this.updatedAt=LocalDateTime.now();
    }


}
