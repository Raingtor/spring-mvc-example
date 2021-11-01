package com.github.Raingtor.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @NonNull
    @Column(name = "finish_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishDate;

    @NonNull
    private String status;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee", referencedColumnName = "id")
    private Employee employee;

    @NonNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product", referencedColumnName = "id")
    )
    private List<Product> products;
}