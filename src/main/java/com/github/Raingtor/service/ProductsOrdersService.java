package com.github.Raingtor.service;

import com.github.Raingtor.entity.ProductsOrders;

import java.util.List;

public interface ProductsOrdersService {
    ProductsOrders findById(String id);

    List<ProductsOrders> findAll();

    String create(ProductsOrders productsOrders) throws Exception;

    void update(String id, ProductsOrders productsOrders);

    void delete(String id);
}
