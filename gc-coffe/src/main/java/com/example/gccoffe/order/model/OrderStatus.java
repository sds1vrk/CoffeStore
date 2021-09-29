package com.example.gccoffe.order.model;

public enum OrderStatus {
    ACCEPTED,
    PAYMENT_CONFIRMED,
    READY_FOR_DELIVERY,
    SHIPPED,
    SETTLED, // 배송완료
    CANCELLED
}
