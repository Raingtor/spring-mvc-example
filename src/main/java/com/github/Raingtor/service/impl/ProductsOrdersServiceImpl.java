package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Client;
import com.github.Raingtor.entity.Order;
import com.github.Raingtor.entity.ProductsOrders;
import com.github.Raingtor.repository.ProductsOrdersRepository;
import com.github.Raingtor.service.OrderService;
import com.github.Raingtor.service.ProductService;
import com.github.Raingtor.service.ProductsOrdersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class ProductsOrdersServiceImpl implements ProductsOrdersService {
    private ProductsOrdersRepository productsOrdersRepository;

    private ProductService productsService;

    private OrderService orderService;

    public ProductsOrders findById(String id) {
        return productsOrdersRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Client.class.getSimpleName(), id));
    }

    public List<ProductsOrders> findAll() {
        return productsOrdersRepository.findAll();
    }

    @Transactional
    public String create(ProductsOrders productsOrders) throws Exception {
        if (productsOrders.getProduct().getAmount() - productsOrders.getAmount() >= 0) {
            productsOrders.getProduct().setAmount(productsOrders.getProduct().getAmount() - productsOrders.getAmount());
            productsService.update(productsOrders.getProduct().getId(), productsOrders.getProduct());
        } else {
            throw new Exception("Простите, товар " + productsOrders.getProduct().getName() + " закончился на складе.");
        }
        return productsOrdersRepository.saveAndFlush(productsOrders).getId();
    }

    public void update(String id, ProductsOrders productsOrders) {

    }

    public void delete(String id) {

    }
}
