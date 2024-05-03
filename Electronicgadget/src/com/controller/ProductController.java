package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;

public class ProductController {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        ProductService productService = new ProductService();

	        while (true) {
	            System.out.println("1. Get all products");
	            System.out.println("2. Get product by ID");
	            System.out.println("3. Add new product");
	            System.out.println("4. Update product");
	            System.out.println("5. Delete product");
	            System.out.println("6. To check quantity of the product");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	          
	                switch (choice) {
	                    case 1:
	                        List<Product> products = productService.getAllProducts();
	                        for (Product p : products) {
	                            System.out.println(p);
	                        }
	                        break;
	                    case 2:
	                        System.out.print("Enter product ID: ");
	                        int productId = sc.nextInt();
	                        Product product = productService.getProductById(productId);
	                        System.out.println(product);
	                        break;
	                    case 3:
	                    	Product newProduct = new Product();
	                        System.out.print("Enter product name: ");
	                        String productName = sc.nextLine();
	                        newProduct.setProductName(productName);
	                        System.out.print("Enter product description: ");
	                        String description = sc.nextLine();
	                        newProduct.setDescription(description);
	                        System.out.print("Enter product price: ");
	                        double price = sc.nextDouble();
	                        newProduct.setPrice(price);
	                        //Product newProduct = new Product(productName, description, price);
	                        productService.addProduct(newProduct);
	                        System.out.println("Product added successfully");
	                        break;
	                    case 4:
	                        System.out.print("Enter product ID to update: ");
	                        int updateProductId = sc.nextInt();
	                        sc.nextLine(); // consume newline
	                        System.out.print("Enter new product name: ");
	                        String updatedProductName = sc.nextLine();
	                        System.out.print("Enter new product description: ");
	                        String updatedDescription = sc.nextLine();
	                        System.out.print("Enter new product price: ");
	                        double updatedPrice = sc.nextDouble();
	                        System.out.println("ENter Qunatity To Update");
	                        int quantity = sc.nextInt();
	                        Product updatedProduct = new Product(updateProductId, updatedProductName, updatedDescription, updatedPrice, quantity);
	                        productService.updateProduct(updatedProduct);
	                        System.out.println("Product updated successfully");
	                        break;
	                    case 5:
	                        System.out.print("Enter product ID to delete: ");
	                        int deleteProductId = sc.nextInt();
	                        productService.deleteProduct(deleteProductId);
	                        System.out.println("Product deleted successfully");
	                        break;
	                        
	                    case 6:
	                        System.out.print("Enter product ID to check quantity: ");
	                        int checkProductId = sc.nextInt();
	                        int quantity1 = productService.getProductQuantity(checkProductId);
	                        if (quantity1 > 0) {
	                            System.out.println("Product quantity is: " + quantity1);
	                        } else {
	                            System.out.println("Product quantity is 0 or product does not exist.");
	                        }
	                        break;

	                    case 0:
	                        System.out.println("Exiting...");
	                        System.exit(0);
	                        break;
	                    default:
	                        System.out.println("Invalid choice! Please try again.");
	                        break;
	                }
	           
	}
	}
}
