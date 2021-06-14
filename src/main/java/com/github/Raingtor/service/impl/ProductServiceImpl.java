package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.Raingtor.repository.ProductRepository;
import com.github.Raingtor.service.ProductService;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Product.class.getSimpleName(), id));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public String create(Product product) {
        return productRepository.saveAndFlush(product).getId();
    }

    public void update(String id, Product product) {
        if (findById(id) != null) {
            product.setId(id);
            productRepository.saveAndFlush(product);
        } else {
            throw new ObjectNotFoundException(Product.class.getSimpleName(), id);
        }
    }

    public void delete(String id) {
        if (findById(id) != null) {
            productRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Product.class.getSimpleName(), id);
        }
    }
}
