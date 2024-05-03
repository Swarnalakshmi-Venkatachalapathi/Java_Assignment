package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDao;
import com.model.Customer;
import com.utility.DBConfig;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAll(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConfig.dbConnect();
		String sql = "select * from customers where customerID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		List <Customer> list = new ArrayList<>();
		while(rst.next()) {
		int customerID = rst.getInt("CustomerID");
		String fName = rst.getString("FirstName");
		String lName = rst.getString("LastName");
		String email = rst.getString("Email");
		String phone = rst.getString("Phone");
		String address = rst.getString("Address");
		
		Customer customer = new Customer(customerID,fName,lName,email,phone,address);
		list.add(customer);
		}
		DBConfig.dbClose();
		return list;
	}

	@Override
	public int updateCustomerDetail(Customer customer1) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConfig.dbConnect();
		String sql = "Update customers Set Email=?,Phone=?,Address=? where CustomerID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,customer1.getEmail());
		pstmt.setString(2, customer1.getPhone());
		pstmt.setString(3, customer1.getAddress());
		pstmt.setInt(4, customer1.getCustomerID());
		int status = pstmt.executeUpdate();
		
		DBConfig.dbClose();
		
		return status;
	}

}
