package com.firatsivrikaya.cursorbased.paging.repository;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByIdGreaterThanEqual(Long id, Pageable pageable);
}
