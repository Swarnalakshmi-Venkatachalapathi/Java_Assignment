package com.service;
import java.sql.SQLException;

import com.dao.*;
import com.daoImpl.*;
import com.model.OrderDetail;
public class OrderDetailService {
OrderDetailDao dao = new OrderDetailDaoImpl();
public double calculateSubtotal(int orderDetailID) throws SQLException {
    return dao.calculateSubtotal(orderDetailID);
}

public OrderDetail getOrderDetailInfo(int orderDetailID) throws SQLException {
	return dao.getOrderDetailInfo(orderDetailID);
	
}
public void updateQuantity(int orderDetailID, int newQuantity) throws SQLException {
    dao.updateQuantity(orderDetailID, newQuantity);
}

public void addDiscount(int orderDetailID, double discountAmount) throws SQLException {
    dao.addDiscount(orderDetailID, discountAmount);
}
}
