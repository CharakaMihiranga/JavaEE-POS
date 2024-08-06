package lk.ijse.gdse.javaee.posbackend.dao.custom.impl;

import lk.ijse.gdse.javaee.posbackend.dao.custom.CustomerDAO;
import lk.ijse.gdse.javaee.posbackend.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public static String SAVE_CUSTOMER = "INSERT INTO customer VALUES(?, ?, ?, ?)";
    public static String UPDATE_CUSTOMER = "UPDATE customer SET name=?, address=?, salary=? WHERE customerId=?";
    public static String DELETE_CUSTOMER = "DELETE FROM customer WHERE customerId=?";
    public static String GET_CUSTOMER = "SELECT * FROM customer WHERE customerId=?";
    public static String GET_ALL_CUSTOMERS ="SELECT * FROM customer";

    @Override
    public String save(Customer entity, Connection connection) throws Exception {
        try{
            var ps = connection.prepareStatement(SAVE_CUSTOMER);
            ps.setString(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getAddress());
            ps.setDouble(4, entity.getSalary());

            if (ps.executeUpdate() != 0 ){
                return "Customer saved successfully!";
            }else {
                return "Failed to save the customer!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(String id, Customer entity, Connection connection) throws Exception {
        System.out.println("CustomerDAOImpl.update:"+id);
        try{
            var ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getAddress());
            ps.setDouble(3, entity.getSalary());
            ps.setString(4, id);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id, Connection connection) throws Exception {
        try {
            var ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setString(1, id);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer get(String id, Connection connection) throws Exception {

        Customer customer = new Customer();
        try{
            var ps = connection.prepareStatement(GET_CUSTOMER);
            ps.setString(1, id);
            var rst = ps.executeQuery();
            while(rst.next()){
              customer.setId(rst.getString("customerId"));
              customer.setName(rst.getString("name"));
              customer.setAddress(rst.getString("address"));
              customer.setSalary(rst.getDouble("salary"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try{
            var ps = connection.prepareStatement(GET_ALL_CUSTOMERS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                customers.add(new Customer(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("salary")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
