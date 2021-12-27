package com.firatsivrikaya.cursorbased.paging.initializer;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;
import com.firatsivrikaya.cursorbased.paging.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final ICustomerRepository customerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        customerRepository.save(Customer.builder().name("Firat").surname("S").build());
        customerRepository.save(Customer.builder().name("Firat").surname("S1").build());
        customerRepository.save(Customer.builder().name("Firat").surname("S2").build());
        customerRepository.save(Customer.builder().name("Firat").surname("S3").build());
    }
}
