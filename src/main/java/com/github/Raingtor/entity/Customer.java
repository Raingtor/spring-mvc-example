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
@Table(name = "customers")
public class Customer{
    @Column(name = "id")
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    private String surName;

    @NonNull
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String gender;

    @NonNull
    private String phone;

    @NonNull
    private String email;

    @NonNull
    private String address;
}