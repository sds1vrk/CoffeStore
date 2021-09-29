package com.example.gccoffe.order.model;
import com.example.gccoffe.product.model.Category;

import java.util.UUID;

public record OrderItem (UUID productId, Category category, long price, int quantity){
}
