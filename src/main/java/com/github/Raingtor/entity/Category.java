package com.github.Raingtor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    private String name;

    @NonNull
    private String description;
}