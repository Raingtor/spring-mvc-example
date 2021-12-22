package com.github.Raingtor.entity;

import com.github.Raingtor.service.ProductService;
import com.github.Raingtor.service.impl.ProductServiceImpl;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_orders")
public class ProductsOrders {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    private int amount;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "order_", referencedColumnName = "id")
    private Order order;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;
}
