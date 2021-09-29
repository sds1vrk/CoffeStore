package com.example.gccoffe.product.controller;

import com.example.gccoffe.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productPage(Model model) {
        var products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "product-list";
    }

    @GetMapping("new-product")
    public String newProductPage(){
        return "new-product";

    }

    @PostMapping("/products")
    public String newProduct(CreateProductRequest createdProductRequest) {
        productService.createdProduct(
                createdProductRequest.productName(),
                createdProductRequest.category(),
                createdProductRequest.price(),
                createdProductRequest.description());
        return "redirect:/products";

    }

}
