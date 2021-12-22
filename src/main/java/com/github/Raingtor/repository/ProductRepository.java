package com.github.Raingtor.repository;

import com.github.Raingtor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    //todo учитывать кол-во заказанных товаров
    String FIND_TOP_PRODUCTS_BETWEEN_DATES =
            "SELECT p.* FROM products p " +
            "JOIN products_orders po ON p.id = po.product " +
            "JOIN statuses_orders so ON po.order = so.order " +
            "JOIN statuses s ON so.status = s.id " +
            "WHERE s.name = 'Оформлен' AND (so.date BETWEEN :start AND :end) " +
            "GROUP BY p.id " +
            "ORDER BY COUNT(p.id) DESC " +
            "LIMIT 5";

    String IMPORT_FROM_CSV = "call IMPORT_PRODUCTS_FROM_CSV(:file)";

    @Query(value = FIND_TOP_PRODUCTS_BETWEEN_DATES, nativeQuery = true)
    List<Product> findTopProductsBetweenDates(@Param("start") Date start, @Param("end") Date end);

    @Query(value = IMPORT_FROM_CSV, nativeQuery = true)
    void importFromCsv(@Param("file") String filePath);
}