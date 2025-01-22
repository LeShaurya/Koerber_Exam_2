package com.customer_app.repositories;

import com.customer_app.exception.CustomerNotFound;
import com.customer_app.exception.DAOException;
import com.customer_app.factory.ConnectionFactory;
import com.customer_app.models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImplementation implements CustomerRepository{

    private final Connection connection;

    public CustomerRepositoryImplementation() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM customer");
            while(result.next())
                customers.add(new Customer(result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getDouble("phoneNumber")));
        } catch (SQLException e) {
            throw new DAOException("failed", e);
        }
        return customers;
    }

    @Override
    public int createCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer(name, address, phoneNumber) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setDouble(3, customer.getPhoneNumber());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
            throw new SQLException("Creating customer failed, no ID obtained.");
        } catch (SQLException e) {
            throw new DAOException("failed", e);
        }
    }


    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result=preparedStatement.executeQuery();
            if (result.next()){
                customer= new Customer(result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getDouble("phoneNumber"));
            } else {
                throw new CustomerNotFound("Customer with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new DAOException("failed", e);
        }
        return customer;
    }
}
