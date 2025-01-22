package com.customer_app.services;

import com.customer_app.exception.CustomerNotFound;
import com.customer_app.exception.DAOException;
import com.customer_app.models.Customer;
import com.customer_app.repositories.CustomerRepository;
import com.customer_app.repositories.CustomerRepositoryImplementation;

import java.util.List;

public class CustomerServiceImplementation implements CustomerService{

    CustomerRepository customerRepository = new CustomerRepositoryImplementation();

    @Override
    public List<Customer> getAllCustomers() throws DAOException{
        return customerRepository.getAllCustomers();
    }

    @Override
    public int createCustomer(Customer customer) throws DAOException{
            return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) throws CustomerNotFound, DAOException {
        return customerRepository.getCustomerById(id);
    }
}
