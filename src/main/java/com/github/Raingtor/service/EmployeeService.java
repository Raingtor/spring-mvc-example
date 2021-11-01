package com.github.Raingtor.service;

import com.github.Raingtor.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(String id);

    List<Employee> findAll();

    String create(Employee employee);

    void update(String id, Employee employee);

    void delete(String id);
}
