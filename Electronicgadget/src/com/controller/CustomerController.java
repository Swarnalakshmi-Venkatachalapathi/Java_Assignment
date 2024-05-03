package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		while(true) {
			System.out.println("1. Get Customer Details");
			System.out.println("2. Update Customer Details");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting..");
				break;
				}
			switch(input) {
			case 1:
				Customer customer = new Customer();
				System.out.println("Enter Customer ID");
				int customerId = sc.nextInt();
				List<Customer> list = customerService.findAll(customerId);
				for(Customer c : list) {
					System.out.println(c);
				}
				break;
			case 2:
				Customer customer1 = new Customer();
				System.out.println("Enter Customer ID");
				 customerId = sc.nextInt();
				 sc.nextLine();
				List<Customer> list1 = customerService.findAll(customerId);
				for(Customer c : list1) {
					System.out.println(c);
				}
				System.out.println("Enter Email Id to update");
				customer1.setEmail(sc.nextLine());
				System.out.println("Enter Phone Number To update");
				customer1.setPhone(sc.nextLine());
				System.out.println("Enter Address To update");
				customer1.setAddress(sc.nextLine());
				
				customerService.updateCustomerDetail(customer1);
				System.out.println("Customer Details Updated...");
				
				break;
			}
			
		}
		
	}

}
