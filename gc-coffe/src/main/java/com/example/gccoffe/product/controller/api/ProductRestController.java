package com.example.gccoffe.product.controller.api;

import com.example.gccoffe.product.model.Category;
import com.example.gccoffe.product.model.Product;
import com.example.gccoffe.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category>category) {
        // 카테고리가 있을경우 param (전달받은) 값을 넣고 serivce에 전달 / 아니면 전체 검색
        return category.map(category1 -> productService.getProductByCategory(category1)).orElse(productService.getAllProducts());
    }


}
