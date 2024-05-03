package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	List<Customer> findAll(int customerId) throws SQLException;

	int updateCustomerDetail(Customer customer1) throws SQLException;

}
