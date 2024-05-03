package com.dao;

import java.sql.SQLException;

import com.model.OrderDetail;

public interface OrderDetailDao {

	double calculateSubtotal(int orderDetailID)throws SQLException;

	OrderDetail getOrderDetailInfo(int orderDetailID) throws SQLException;

	void updateQuantity(int orderDetailID, int newQuantity) throws SQLException;

	void addDiscount(int orderDetailID, double discountAmount) throws SQLException;


}
