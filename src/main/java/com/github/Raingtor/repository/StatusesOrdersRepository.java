package com.github.Raingtor.repository;

import com.github.Raingtor.entity.StatusesOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusesOrdersRepository extends JpaRepository<StatusesOrders, String> {
}
