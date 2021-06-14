package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Column(name = "id")
    private @Id
    String id = UUID.randomUUID().toString();

    @NotBlank(message = "Укажите тип")
    @Column(name = "type")
    private String type;

    @NotBlank(message = "Укажите название")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Укажите описание")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Укажите цену")
    @Column(name = "price")
    private Float price;

    public Product(@NotBlank(message = "Укажите тип") String type, @NotBlank(message = "Укажите название") String name,
                   @NotBlank(message = "Укажите описание") String description,
                   @NotNull(message = "Укажите цену") Float price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
