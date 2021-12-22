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
@Table(name = "clients")
public class Client {
    @Column(name = "id")
    private @Id
    String id = UUID.randomUUID().toString();

    @NonNull
    private String surname;

    @NonNull
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private String phone;

    private String email;

    private String address;

    @NonNull
    @Column(name = "is_manager")
    private String isManager;
}