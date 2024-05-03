package com.dao;

import java.sql.SQLException;

import com.model.Order;

public interface OrderDao {

	Order getOrderDetails(int customerId) throws SQLException;

    void updateOrderStatus(int orderId, String newStatus) throws SQLException;

    void cancelOrder(int orderId) throws SQLException;
    
    int getTotalOrdersByCustomer(int customerId) throws SQLException;

}
