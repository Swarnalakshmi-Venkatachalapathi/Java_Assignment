package com.model;

public class OrderDetail {

	private int orderDetailID;
    private int orderId;
    private int product;
    private int quantity;
	public OrderDetail(int orderDetailID, int orderId, int product, int quantity) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", orderId=" + orderId + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	
    
}
