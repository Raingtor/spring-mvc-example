package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    private @Id
    String id = UUID.randomUUID().toString();

    private String parent;

    @NonNull
    private String name;

    @NonNull
    private String description;
}