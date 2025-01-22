package com.customer_app.repositories;

import com.customer_app.models.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    int createCustomer(Customer customer);
}
