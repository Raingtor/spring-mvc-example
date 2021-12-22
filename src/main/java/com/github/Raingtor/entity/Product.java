package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    @NotBlank(message = "Укажите название")
    private String name;

    @NonNull
    @NotBlank(message = "Укажите описание")
    private String description;

    @NonNull
    @NotNull(message = "Укажите цену")
    private Float price;

    @NonNull
    private int amount;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;
}