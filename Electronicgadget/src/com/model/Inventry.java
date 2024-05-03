package com.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Inventry {

	 private int inventoryID;
	    private int product;
	    private int quantityInStock;
	    private Timestamp LastStockUpdate;
		public Inventry(int inventoryID, int product, int quantityInStock, Timestamp lastStockUpdate) {
			super();
			this.inventoryID = inventoryID;
			this.product = product;
			this.quantityInStock = quantityInStock;
			LastStockUpdate = lastStockUpdate;
		}
		public Inventry() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getInventoryID() {
			return inventoryID;
		}
		public void setInventoryID(int inventoryID) {
			this.inventoryID = inventoryID;
		}
		public int getProduct() {
			return product;
		}
		public void setProduct(int product) {
			this.product = product;
		}
		public int getQuantityInStock() {
			return quantityInStock;
		}
		public void setQuantityInStock(int quantityInStock) {
			this.quantityInStock = quantityInStock;
		}
		public Timestamp getLastStockUpdate() {
			return LastStockUpdate;
		}
		public void setLastStockUpdate(Timestamp timestamp) {
			LastStockUpdate = timestamp;
		}
		@Override
		public String toString() {
			return "Inventry [inventoryID=" + inventoryID + ", product=" + product + ", quantityInStock="
					+ quantityInStock + ", LastStockUpdate=" + LastStockUpdate + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(LastStockUpdate, inventoryID, product, quantityInStock);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Inventry other = (Inventry) obj;
			return Objects.equals(LastStockUpdate, other.LastStockUpdate) && inventoryID == other.inventoryID
					&& product == other.product && quantityInStock == other.quantityInStock;
		}
	
	    
}
