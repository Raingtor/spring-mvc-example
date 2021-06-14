package com.github.Raingtor.repository;

import com.github.Raingtor.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select p from Product p")
    List<Product> sort(Sort sort);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.id = :id")
    void updatePrice(@Param("id") String id, @Param("newPrice") Float price);
}