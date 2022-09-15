package io.czen.customvalidation.controller;

import io.czen.customvalidation.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public Customer getCustomer(@Valid @RequestBody Customer customer) {
        return customer;
    }
}
