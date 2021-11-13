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
@Table(name = "employees")
public class Employee {
    @Column(name = "id")
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    private String surName;

    @NonNull
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @NonNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NonNull
    private String gender;

    @NonNull
    private String position;
}
