package com.github.Raingtor.service;

import com.github.Raingtor.entity.Order;

import java.util.List;

public interface OrderService {
    Order findById(String id);

    List<Order> findAll();

    String create(Order order);

    void update(String id, Order order);

    void delete(String id);
}
