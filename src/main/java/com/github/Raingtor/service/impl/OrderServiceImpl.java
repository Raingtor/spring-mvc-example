package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Order;
import com.github.Raingtor.repository.OrderRepository;
import com.github.Raingtor.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Order.class.getSimpleName(), id));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public String create(Order order) {
        return orderRepository.saveAndFlush(order).getId();
    }

    public void update(String id, Order order) {
        if (findById(id) != null) {
            order.setId(id);
            orderRepository.saveAndFlush(order);
        } else {
            throw new ObjectNotFoundException(Order.class.getSimpleName(), id);
        }
    }

    public void delete(String id) {
        if (findById(id) != null) {
            orderRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Order.class.getSimpleName(), id);
        }
    }
}
