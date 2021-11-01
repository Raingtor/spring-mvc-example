package com.github.Raingtor.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    @Column(name = "full_Name")
    private String fullName;

    @NonNull
    @Column(name = "position")
    private String position;

    @NonNull
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;
}
