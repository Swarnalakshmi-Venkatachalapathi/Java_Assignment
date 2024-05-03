package com.model;

public class Order {

	 private int orderID;
	    private int customerId;
	    private String orderDate;
	    private double totalAmount;
		public Order(int orderID, int customerId, String orderDate, double totalAmount) {
			super();
			this.orderID = orderID;
			this.customerId = customerId;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
		}
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getOrderID() {
			return orderID;
		}
		public void setOrderID(int orderID) {
			this.orderID = orderID;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		@Override
		public String toString() {
			return "Order [orderID=" + orderID + ", customerId=" + customerId + ", orderDate=" + orderDate
					+ ", totalAmount=" + totalAmount + "]";
		}
		
	    
}
