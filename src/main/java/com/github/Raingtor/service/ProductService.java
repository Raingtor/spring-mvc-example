package com.github.Raingtor.service;

import com.github.Raingtor.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(String id);

    List<Product> findAll();

    String create(Product product);

    void update(String id, Product product);

    void delete(String id);
}
