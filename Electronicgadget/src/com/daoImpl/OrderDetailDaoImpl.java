package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.OrderDetailDao;
import com.model.OrderDetail;
import com.utility.DBConfig;

public class OrderDetailDaoImpl implements OrderDetailDao{

	 @Override
	    public double calculateSubtotal(int orderDetailID) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "SELECT Quantity, Price FROM OrderDetails WHERE OrderDetailID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, orderDetailID);
	        ResultSet rs = pstmt.executeQuery();
	        double subtotal = 0;
	        if (rs.next()) {
	            int quantity = rs.getInt("Quantity");
	            double price = rs.getDouble("Price");
	            subtotal = quantity * price;
	        }
	        DBConfig.dbClose();
	        return subtotal;
	    }

	    @Override
	    public OrderDetail getOrderDetailInfo(int orderDetailID) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "SELECT * FROM OrderDetails WHERE OrderDetailID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, orderDetailID);
	        ResultSet rs = pstmt.executeQuery();
	        OrderDetail orderDetail = null;
	        while (rs.next()) {
	            // Display information about the order detail
	        	int OrderDetailId = rs.getInt("OrderDetailID");
	        	int orderId = rs.getInt("orderId");
	        	int productId = rs.getInt("ProductID");
	            int quantity = rs.getInt("Quantity");
	            orderDetail = new OrderDetail(orderDetailID,orderId, productId, quantity);
	            
	            // Display other information as needed
	        } 
	        DBConfig.dbClose();
			return orderDetail;
	    }

	 @Override
	    public void updateQuantity(int orderDetailID, int newQuantity) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "UPDATE OrderDetails SET Quantity = ? WHERE OrderDetailID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, newQuantity);
	        pstmt.setInt(2, orderDetailID);
	        pstmt.executeUpdate();
	        DBConfig.dbClose();
	    }
	 
	 @Override
	    public void addDiscount(int orderDetailID, double discountAmount) throws SQLException {
	        Connection con = DBConfig.dbConnect();
	        String sql = "UPDATE OrderDetails SET DiscountAmount = ? WHERE OrderDetailID = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setDouble(1, discountAmount);
	        pstmt.setInt(2, orderDetailID);
	        pstmt.executeUpdate();
	        DBConfig.dbClose();
	    }
}
