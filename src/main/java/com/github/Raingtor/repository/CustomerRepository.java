package com.github.Raingtor.repository;

import com.github.Raingtor.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByFullNameAndEmail(String fullName, String address);
}