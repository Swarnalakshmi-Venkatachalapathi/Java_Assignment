package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.OrderDao;
import com.model.Order;
import com.utility.DBConfig;

public class OrderDaoImpl implements OrderDao{

	   @Override
	    public Order getOrderDetails(int customerId) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "SELECT * FROM orders WHERE CustomerID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, customerId);
	        ResultSet rs = pstmt.executeQuery();
	        Order order = new Order();
	        while (rs.next()) {
	            // Populate Order object
	            
	            order.setOrderID(rs.getInt("OrderID"));
	            order.setCustomerId(rs.getInt(customerId));
	            order.setOrderDate(rs.getString("OrderDate"));
	            order.setTotalAmount(rs.getDouble("TotalAmount"));
	            
	            // Set other attributes similarly
	            
	        } 
	        return order;
	    }

	    @Override
	    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "UPDATE orders SET Status = ? WHERE OrderID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, newStatus);
	        pstmt.setInt(2, orderId);
	        pstmt.executeUpdate();
	        DBConfig.dbClose();
	    }

	    @Override
	    public void cancelOrder(int orderId) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "DELETE FROM orders WHERE OrderID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, orderId);
	        pstmt.executeUpdate();
	        DBConfig.dbClose();
	    }
	    @Override
	    public int getTotalOrdersByCustomer(int customerId) throws SQLException {
	       
	            Connection con = DBConfig.dbConnect();
	            String sql = "SELECT COUNT(*) AS totalOrders FROM orders WHERE CustomerID = ?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, customerId);
	            ResultSet rs = pstmt.executeQuery();
	            int totalOrders = 0;
	            if (rs.next()) {
	                totalOrders = rs.getInt("totalOrders");
	            }
	        
	            DBConfig.dbClose(); // Close resources
	       

	        return totalOrders;
	    }

}
