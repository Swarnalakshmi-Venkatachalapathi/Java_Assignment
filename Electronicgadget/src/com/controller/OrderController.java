package com.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Order;
import com.service.*;
public class OrderController {
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
     OrderService orderService = new OrderService();
     while(true){
         System.out.println("1. Get order details");
         System.out.println("2. Update order status");
         System.out.println("3. Cancel order");
         System.out.println("4. Total orders Placed by customer");
         
         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");
         
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline
         switch (choice) {
             case 1:
                 // Get order details
                
                 System.out.print("Enter customer ID: ");
                 int customerId = scanner.nextInt();
                 try {
                     Order order = orderService.getOrderDetails(customerId);
                     if (order != null) {
                         System.out.println(order);
                     } else {
                         System.out.println("Order not found.");
                     }
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 2:
                 // Update order status
                 
                 System.out.print("Enter order ID: ");
                 int updateOrderId = scanner.nextInt();
                 System.out.print("Enter new status: ");
                 String newStatus = scanner.next();
                 try {
                     orderService.updateOrderStatus(updateOrderId, newStatus);
                     System.out.println("Order status updated successfully.");
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 3:
                 // Cancel order
                
                 System.out.print("Enter order ID to cancel: ");
                 int cancelOrderId = scanner.nextInt();
                 try {
                     orderService.cancelOrder(cancelOrderId);
                     System.out.println("Order cancelled successfully.");
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 4:
                 System.out.print("Enter customer ID: ");
                  customerId = scanner.nextInt();
                 try {
                     int totalOrders = orderService.calculateTotalOrders(customerId);
                     System.out.println("Total orders placed by customer: " + totalOrders);
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
       
             case 0:
                 System.out.println("Exiting...");
                 break;
         }}
}}
