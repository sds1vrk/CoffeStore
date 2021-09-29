package com.example.gccoffe.product.service;

import com.example.gccoffe.product.model.Category;
import com.example.gccoffe.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductByCategory(Category category);
    List<Product> getAllProducts();
    Product createdProduct(String productName, Category category, long price);
    Product createdProduct(String productName, Category category, long price, String description);

}
