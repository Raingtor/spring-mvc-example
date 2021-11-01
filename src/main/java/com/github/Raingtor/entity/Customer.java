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
    @Column(name = "full_Name")
    private String fullName;

    @NonNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NonNull
    private String gender;

    @NonNull
    private String phone;

    @NonNull
    private String email;

    @NonNull
    private String address;

    @NonNull
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;
}
