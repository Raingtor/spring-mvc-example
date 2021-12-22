package com.github.Raingtor.repository;

import com.github.Raingtor.entity.ProductsOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOrdersRepository extends JpaRepository<ProductsOrders, String> {
}
