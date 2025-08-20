package service;

import config.DbConfiguration;
import entity.Customer;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {


    public static void addCustomer(Customer customer) throws SQLException{

        Connection connection=DbConfiguration.getConnection();
        String query="INSERT INTO customers(name,phone) VALUES(?,?)";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());

        int data=ps.executeUpdate();
        System.out.println(data+" Customer added successfully");
        connection.close();
        ps.close();
    }

    public List<Customer> getAllCustomer() throws SQLException{
        List<Customer> customers=new ArrayList<>();

        Connection connection=DbConfiguration.getConnection();
        Statement st=connection.createStatement();
        String query="SELECT * from customers";
        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
            customers.add(new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("phone")));
        }
        connection.close();
        st.close();
        return customers;

    }

    public static Customer getCustomerBasedOnNumber(String number) throws SQLException{
        Connection connection=DbConfiguration.getConnection();
        Statement st=connection.createStatement();
        String query="SELECT * from customers where phone="+number;
        ResultSet rs=st.executeQuery(query);
        if (rs.next()) {
            return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
        } else {
            return null; // or throw an exception, depending on your logic
        }
    }

}
