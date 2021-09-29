package com.example.gccoffe.product.repository;

import com.example.gccoffe.product.model.Category;
import com.example.gccoffe.product.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    // 검색
    List<Product> findAll();
    // 아이디, 이름이 없을수도 있으므로 Optional 처리
    Optional<Product> findById(UUID productId);
    Optional<Product> findByName(String productName);
    List<Product> findByCategory(Category category);

    // 삽입
    Product insert(Product product);
    // 수정
    Product update(Product product);
    // 삭제
    void deleteAll();

}
