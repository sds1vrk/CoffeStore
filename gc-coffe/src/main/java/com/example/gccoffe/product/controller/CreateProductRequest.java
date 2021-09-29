package com.example.gccoffe.product.controller;

import com.example.gccoffe.product.model.Category;

public record CreateProductRequest(String productName, Category category, long price, String description) {
}
