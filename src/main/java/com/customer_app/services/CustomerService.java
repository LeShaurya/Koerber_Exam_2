package com.customer_app.services;

import com.customer_app.models.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    int createCustomer(Customer customer);
    Customer getCustomerById(int id);
}
