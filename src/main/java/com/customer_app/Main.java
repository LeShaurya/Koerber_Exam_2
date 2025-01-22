package com.customer_app;

import com.customer_app.models.Customer;
import com.customer_app.services.CustomerService;
import com.customer_app.services.CustomerServiceImplementation;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImplementation();
        customerService.getAllCustomers().forEach(System.out::println);

        Customer customer = new Customer("name4", "address4", 676576);
        try {
            int customerAdded = customerService.createCustomer(customer);
            System.out.println(customerAdded + "is the Id");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        Customer customerById = customerService.getCustomerById(1);
        System.out.println(customerById);
    }
}