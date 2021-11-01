package com.github.Raingtor.service;

import com.github.Raingtor.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(String id);

    List<Customer> findAll();

    String create(Customer customer);

    void update(String id, Customer customer);

    void delete(String id);
}
