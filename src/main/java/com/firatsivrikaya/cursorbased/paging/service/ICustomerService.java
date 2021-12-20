package com.firatsivrikaya.cursorbased.paging.service;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<Customer> getById(Long id);

    Customer save(Customer customer);

    List<Customer> saveAll(List<Customer> customerList);

    List<Customer> getAllByName(String name, Long id, int size);
}
