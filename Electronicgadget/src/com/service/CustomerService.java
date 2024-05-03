package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;
import com.dao.*;
import com.daoImpl.*;
public class CustomerService {
CustomerDao dao = new CustomerDaoImpl();
	public List<Customer> findAll(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll(customerId);
	}
	public int updateCustomerDetail(Customer customer1) throws SQLException{
		return dao.updateCustomerDetail(customer1);
		// TODO Auto-generated method stub
		
	}

}
