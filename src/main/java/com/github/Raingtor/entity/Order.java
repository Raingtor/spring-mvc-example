package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;
}