package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "statuses")
public class Status {
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    @NotBlank(message = "Укажите название")
    private String name;
}
