package com.firatsivrikaya.cursorbased.paging.controller;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;
import com.firatsivrikaya.cursorbased.paging.extractor.IdBasedCursorTokenExtractor;
import com.firatsivrikaya.cursorbased.paging.resource.CustomerContainerResource;
import com.firatsivrikaya.cursorbased.paging.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping(value = "/{name}", produces = "application/json")
    public ResponseEntity<CustomerContainerResource> getBook(@PathVariable String name, @RequestParam(required = false, defaultValue = "0") String nextPageToken, @RequestParam( defaultValue = "1") int size) {
        Long id = Long.valueOf(nextPageToken);
        List<Customer> customerList = customerService.getAllByName(name, id, size + 1);
        Pair<Long, List<Customer>> pair = IdBasedCursorTokenExtractor.extract(customerList, size, Customer::getId);
        Long nextPage = pair.getLeft();
        List<Customer> customers = pair.getRight();
        CustomerContainerResource result = CustomerContainerResource.builder().nextPageToken(nextPage).customers(customers).build();
        return ResponseEntity.ok().body(result);


    }


}
