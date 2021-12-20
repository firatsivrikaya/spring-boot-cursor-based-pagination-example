package com.firatsivrikaya.cursorbased.paging.service.impl;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;
import com.firatsivrikaya.cursorbased.paging.repository.ICustomerRepository;
import com.firatsivrikaya.cursorbased.paging.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> getById(Long id) {
        Optional<Customer> result = customerRepository.findById(id);
        return result;
    }

    @Override
    public Customer save(Customer customer) {
        Customer result = customerRepository.save(customer);
        return result;
    }

    @Override
    public List<Customer> saveAll(List<Customer> customerList) {
        List<Customer> result = customerRepository.saveAll(customerList);
        return result;
    }

    @Override
    public List<Customer> getAllByName(String name, Long id, int size) {
        final Pageable pageable = PageRequest.of(0, size, Sort.by(Sort.Direction.ASC, "id"));
        List<Customer> result = customerRepository.findAllByNameAndIdGreaterThanEqual(name, id ,pageable);
        return result;
    }
}
