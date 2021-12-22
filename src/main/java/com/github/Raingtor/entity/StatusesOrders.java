package com.github.Raingtor.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "statuses_orders")
public class StatusesOrders {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "order_", referencedColumnName = "id")
    private Order order;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private Status status;
}
