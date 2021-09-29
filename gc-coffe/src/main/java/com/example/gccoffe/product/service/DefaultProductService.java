package com.example.gccoffe.product.service;

import com.example.gccoffe.product.model.Category;
import com.example.gccoffe.product.model.Product;
import com.example.gccoffe.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProductByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createdProduct(String productName, Category category, long price) {
        var product=new Product(UUID.randomUUID(),productName,category,price);
        return productRepository.insert(product);
    }

    @Override
    public Product createdProduct(String productName, Category category, long price, String description) {
        var product=new Product(UUID.randomUUID(),productName,category,price,description, LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        return productRepository.insert(product);
    }
}
