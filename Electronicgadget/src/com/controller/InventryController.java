package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Inventry;
import com.model.Product;
import com.service.InventryService;

public class InventryController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        InventryService inventoryService = new InventryService();

	        while (true) {
	            System.out.println("1. Get product");
	            System.out.println("2. Get quantity in stock");
	            System.out.println("3. Add to inventory");
	            System.out.println("4. Remove from inventory");
	            System.out.println("5. Update stock quantity");
	            System.out.println("6. Check if product is available");
	            System.out.println("7. Get inventory value");
	            System.out.println("8. List low stock products");
	            System.out.println("9. List out of stock products");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            switch (choice) {
	                case 1:
	                    // Get product
	                    System.out.print("Enter inventory ID: ");
	                    int inventoryID = scanner.nextInt();
	                    try {
	                        Inventry inventory = inventoryService.getProduct(inventoryID);
	                        if (inventory != null) {
	                            System.out.println(inventory.getProduct());
	                        } else {
	                            System.out.println("Inventory not found.");
	                        }
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 2:
	                    // Get quantity in stock
	                    System.out.print("Enter inventory ID: ");
	                    inventoryID = scanner.nextInt();
	                    try {
	                        int quantity = inventoryService.getQuantityInStock(inventoryID);
	                        System.out.println("Quantity in stock: " + quantity);
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 3:
	                    // Add to inventory
	                    System.out.print("Enter inventory ID: ");
	                    inventoryID = scanner.nextInt();
	                    System.out.print("Enter quantity to add: ");
	                    int quantityToAdd = scanner.nextInt();
	                    try {
	                        inventoryService.addToInventory(inventoryID, quantityToAdd);
	                        System.out.println("Quantity added to inventory.");
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 4:
	                    // Remove from inventory
	                    System.out.print("Enter inventory ID: ");
	                    inventoryID = scanner.nextInt();
	                    System.out.print("Enter quantity to remove: ");
	                    int quantityToRemove = scanner.nextInt();
	                    try {
	                        inventoryService.removeFromInventory(inventoryID, quantityToRemove);
	                        System.out.println("Quantity removed from inventory.");
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 5:
	                    // Update stock quantity
	                    System.out.print("Enter inventory ID: ");
	                    inventoryID = scanner.nextInt();
	                    System.out.print("Enter new stock quantity: ");
	                    int newQuantity = scanner.nextInt();
	                    try {
	                        inventoryService.updateStockQuantity(inventoryID, newQuantity);
	                        System.out.println("Stock quantity updated.");
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 6:
	                    // Check if product is available
	                    System.out.print("Enter inventory ID: ");
	                    inventoryID = scanner.nextInt();
	                    System.out.print("Enter quantity to check: ");
	                    int quantityToCheck = scanner.nextInt();
	                    try {
	                        boolean isAvailable = inventoryService.isProductAvailable(inventoryID, quantityToCheck);
	                        if (isAvailable) {
	                            System.out.println("Product is available.");
	                        } else {
	                            System.out.println("Product is not available.");
	                        }
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 7:
	                    // Get inventory value
	                    try {
	                        double inventoryValue = inventoryService.getInventoryValue();
	                        System.out.println("Total inventory value: " + inventoryValue);
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 8:
	                	 System.out.print("Enter threshold quantity: ");
	                	    int threshold = scanner.nextInt();
	                	    try {
	                	        List<Product> lowStockProducts = inventoryService.listLowStockProducts(threshold);
	                	        if (lowStockProducts.isEmpty()) {
	                	            System.out.println("No products found with quantity below the threshold.");
	                	        } else {
	                	            System.out.println("Low stock products:");
	                	            for (Product product : lowStockProducts) {
	                	                System.out.println(product); // Assuming you have overridden toString() method in Product class
	                	            }
	                	        }
	                	    } catch (SQLException e) {
	                	        System.out.println("Error: " + e.getMessage());
	                	    }
	                	    break;
	                case 9:
	                  
	                	  // List out of stock products
	                    try {
	                        List<Product> outOfStockProducts = inventoryService.listOutOfStockProducts();
	                        if (outOfStockProducts.isEmpty()) {
	                            System.out.println("No products found out of stock.");
	                        } else {
	                            System.out.println("Out of stock products:");
	                            for (Product product : outOfStockProducts) {
	                                System.out.println(product); // Assuming you have overridden toString() method in Product class
	                            }
	                        }
	                    } catch (SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 0:
	                    // Exit
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	}

}}}
