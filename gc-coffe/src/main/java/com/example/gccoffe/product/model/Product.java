package com.example.gccoffe.product.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Product {
    // 고객이 주문한 상품 - 고유 ID값 -> final
    private final UUID productId;
    // 상품은 계속 추가 가능함으로 final X
    private String productName;
    // 상품을 하나의 카테고리로 만들려고 함, enum 카테고리
    private Category category;
    // 원화 - long, 달러 - big decimal or double 사용 (센트 단위로 넣어야 되기 때문에)
    private long price;
    private String description;
    // 상품 주문 일자
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    // 일단 전체 정보 생성자
    public Product(UUID productId, String productName, Category category, long price, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    // 필수 정보 생성자 따로 만듬, createAt은 자동 생성
    public Product(UUID productId, String productName, Category category, long price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    // 전체적인 읽기 위해 getter 정보 추가

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // 변경 가능한 정보들 SET 추가
    // 상품이 변경될떄마다 updatedAt 추가
    public void setProductName(String productName) {
        this.productName = productName;
        this.updatedAt=LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setCategory(Category category) {
        this.category = category;
        this.updatedAt=LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setPrice(long price) {
        this.price = price;
        this.updatedAt=LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt=LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
