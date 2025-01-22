package com.customer_app.services;

import com.customer_app.models.Customer;
import com.customer_app.repositories.CustomerRepository;
import com.customer_app.repositories.CustomerRepositoryImplementation;

import java.util.List;

public class CustomerServiceImplementation implements CustomerService{

    CustomerRepository customerRepository = new CustomerRepositoryImplementation();

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public int createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }
}
