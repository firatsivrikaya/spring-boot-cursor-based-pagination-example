package com.firatsivrikaya.cursorbased.paging.resource;

import com.firatsivrikaya.cursorbased.paging.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerContainerResource {
    private List<Customer> customers;
    private Long nextPageToken;
}
