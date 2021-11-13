package com.github.Raingtor.entity;

import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order", referencedColumnName = "id")
    private Order order;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;

    private int amount;
}
