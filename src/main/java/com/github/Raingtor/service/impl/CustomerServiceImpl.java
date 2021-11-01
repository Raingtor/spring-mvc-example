package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Customer;
import com.github.Raingtor.repository.CustomerRepository;
import com.github.Raingtor.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Customer.class.getSimpleName(), id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public String create(Customer customer) {
        return customerRepository.saveAndFlush(customer).getId();
    }

    public void update(String id, Customer customer) {
        if (findById(id) != null) {
            customer.setId(id);
            customerRepository.saveAndFlush(customer);
        } else {
            throw new ObjectNotFoundException(Customer.class.getSimpleName(), id);
        }
    }

    public void delete(String id) {
        if (findById(id) != null) {
            customerRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Customer.class.getSimpleName(), id);
        }
    }
}
