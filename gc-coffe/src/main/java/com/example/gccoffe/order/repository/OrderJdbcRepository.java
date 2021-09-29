package com.example.gccoffe.order.repository;

import com.example.gccoffe.order.model.Order;
import com.example.gccoffe.order.model.OrderItem;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    @Transactional // 하나라도 에러가 나면 Rollback 처리
    public Order insert(Order order) {
//        jdbcTemplate.update("INSERT INTO orders(order_id,email,address,postcode,order_status ,created_at ,updated_at) " +
//                "VALUES (UUID_TO_BIN(:orderId),:email,:address,:postcode,:orderStatus ,:createdAt ,:updatedAt)",
//        toOrderParaMap(order));

        jdbcTemplate.update("INSERT INTO orders(order_id, email, address, postcode, order_status, created_at, updated_at) " +
                        "VALUES (UUID_TO_BIN(:orderId), :email, :address, :postcode, :orderStatus, :createdAt, :updatedAt)",
                toOrderParamMap(order));


        // orderItem에 대해 반복을 돌면서 items 갱신
//        order.getOrderItem().
//                forEach(item -> jdbcTemplate.update("INSERT INTO order_items(order_id,product_id,category,price,quantity,created_at ,updated_at) " +
//                "VALUES (UUID_TO_BIN(:orderId),UUID_TO_BIN(:productId),:category,:price,:quantity ,:createdAt ,:updatedAt)",
//        toOrderItemParamMap(order.getOrderId(),order.getCreatedAt(),order.getUpdatedAt(),item)));

        order.getOrderItems()
                .forEach(item ->
                        jdbcTemplate.update("INSERT INTO order_items(order_id, product_id, category, price, quantity, created_at, updated_at) " +
                                        "VALUES (UUID_TO_BIN(:orderId), UUID_TO_BIN(:productId), :category, :price, :quantity, :createdAt, :updatedAt)",
                                toOrderItemParamMap(order.getOrderId(), order.getCreatedAt(), order.getUpdatedAt(), item)));

        return order;
    }



    private Map<String, Object> toOrderParamMap(Order order) {
        var paramMap=new HashMap<String, Object>();
        paramMap.put("orderId",order.getOrderId().toString().getBytes());
        paramMap.put("email",order.getEmail().getAddress());
        paramMap.put("address",order.getAddress());
        paramMap.put("postcode",order.getPostcode());
        paramMap.put("orderStatus",order.getOrderStatus().toString());
        paramMap.put("createdAt",order.getCreatedAt());
        paramMap.put("updatedAt",order.getUpdatedAt());
        return paramMap;
    }

    // 하나의 Order가 만들어지면 같은 orderId, createdAt, updatedAt을 갖음, 따라서 파라미터를 넣어서 사용
    private Map<String, Object  > toOrderItemParamMap(UUID orderId, LocalDateTime createdAt, LocalDateTime updatedAt, OrderItem item) {
        var paramMap=new HashMap<String, Object>();
        paramMap.put("orderId",orderId.toString().getBytes());
        paramMap.put("productId",item.productId().toString().getBytes());
        paramMap.put("category",item.category().toString());
        paramMap.put("price",item.price());
        paramMap.put("quantity",item.quantity());
        paramMap.put("createdAt",createdAt);
        paramMap.put("updatedAt",updatedAt);
        return paramMap;
    }

}
