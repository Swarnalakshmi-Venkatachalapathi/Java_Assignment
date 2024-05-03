package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.OrderDetail;
import com.service.OrderDetailService;

public class OrderDetailsController {
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
     OrderDetailService orderDetailsService = new OrderDetailService();

     while (true) {
         System.out.println("1. Calculate Subtotal");
         System.out.println("2. Get Order Detail info");
         System.out.println("3. Update Quantity");
         System.out.println("4. Add Discount");
         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");

         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
            	 System.out.print("Enter order detail ID: ");
                 int orderDetailID = scanner.nextInt();
                 try {
                     double subtotal = orderDetailsService.calculateSubtotal(orderDetailID);
                     System.out.println("Subtotal for order detail " + orderDetailID + ": " + subtotal);
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 2:
            	 System.out.print("Enter order detail ID: ");
                 orderDetailID = scanner.nextInt();
                 try {
                     OrderDetail orderDetails = orderDetailsService.getOrderDetailInfo(orderDetailID);
                     System.out.println("Order Detail Information:");
                     System.out.println(orderDetails);
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 3:
                 // Update Quantity
                 System.out.print("Enter order detail ID: ");
                 orderDetailID = scanner.nextInt();
                 System.out.print("Enter new quantity: ");
                 int newQuantity = scanner.nextInt();
                 try {
                     orderDetailsService.updateQuantity(orderDetailID, newQuantity);
                     System.out.println("Quantity updated successfully.");
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 4:
                 // Add Discount
                 System.out.print("Enter order detail ID: ");
                 orderDetailID = scanner.nextInt();
                 System.out.print("Enter discount amount: ");
                 double discountAmount = scanner.nextDouble();
                 try {
                     orderDetailsService.addDiscount(orderDetailID, discountAmount);
                     System.out.println("Discount added successfully.");
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 0:
                 System.out.println("Exiting...");
                 System.exit(0);
                 break;
}
}
}}