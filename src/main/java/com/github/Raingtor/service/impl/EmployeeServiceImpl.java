package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Employee;
import com.github.Raingtor.repository.EmployeeRepository;
import com.github.Raingtor.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public Employee findById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Employee.class.getSimpleName(), id));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public String create(Employee employee) {
        return employeeRepository.saveAndFlush(employee).getId();
    }

    public void update(String id, Employee employee) {
        if (findById(id) != null) {
            employee.setId(id);
            employeeRepository.saveAndFlush(employee);
        } else {
            throw new ObjectNotFoundException(Employee.class.getSimpleName(), id);
        }
    }

    public void delete(String id) {
        if (findById(id) != null) {
            employeeRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Employee.class.getSimpleName(), id);
        }
    }
}
