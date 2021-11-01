package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    public Product(@NotBlank(message = "Укажите категорию") Category category, @NotBlank(message = "Укажите название") String name,
                   @NotBlank(message = "Укажите описание") String description,
                   @NotNull(message = "Укажите цену") Float price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private @Id
    String id = UUID.randomUUID().toString();

    @NotBlank(message = "Укажите название")
    private String name;

    @NotBlank(message = "Укажите описание")
    private String description;

    @NotNull(message = "Укажите цену")
    private Float price;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;
}