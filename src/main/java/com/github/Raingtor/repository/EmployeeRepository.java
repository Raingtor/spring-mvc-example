package com.github.Raingtor.repository;

import com.github.Raingtor.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("select e from Employee e where e.position = :position")
    List<Employee> findByPosition(@Param("position") String position);
}