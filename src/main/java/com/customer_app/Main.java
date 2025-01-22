package com.customer_app;

import com.customer_app.models.Customer;
import com.customer_app.services.CustomerService;
import com.customer_app.services.CustomerServiceImplementation;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImplementation();
        customerService.getAllCustomers();

        Customer customer = new Customer("name", "address", 91333528);
        int customerAdded = customerService.createCustomer(customer);
        System.out.println(customerAdded + "is the Id");

        Customer customerById = customerService.getCustomerById(1);
        System.out.println(customerById);
    }
}