package com.service;

import com.model.Order;

import java.sql.SQLException;

import com.dao.*;
import com.daoImpl.*;
public class OrderService {
OrderDao orderDao = new OrderDaoImpl();
	   public Order getOrderDetails(int customerId) throws SQLException {
	        return orderDao.getOrderDetails(customerId);
	    }

	    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
	        orderDao.updateOrderStatus(orderId, newStatus);
	    }

	    public void cancelOrder(int orderId) throws SQLException {
	        orderDao.cancelOrder(orderId);
	    }
	    
	    public int calculateTotalOrders(int customerId) throws SQLException {
	        return orderDao.getTotalOrdersByCustomer(customerId);
	    }
	    
	  
}
