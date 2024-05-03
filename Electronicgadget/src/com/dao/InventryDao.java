package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Inventry;
import com.model.Product;

public interface InventryDao {
	Inventry getProduct(int inventoryID) throws SQLException;

    int getQuantityInStock(int inventoryID) throws SQLException;

    void addToInventory(int inventoryID, int quantityToAdd) throws SQLException;

    void removeFromInventory(int inventoryID, int quantityToRemove) throws SQLException;

    void updateStockQuantity(int inventoryID, int newQuantity) throws SQLException;

    boolean isProductAvailable(int inventoryID, int quantityToCheck) throws SQLException;

    double getInventoryValue() throws SQLException;

    List<Inventry> listLowStockProducts(int threshold) throws SQLException;

    List<Inventry> listOutOfStockProducts() throws SQLException;

	List<Product> getLowStockProducts(int threshold) throws SQLException;

	List<Product> getOutOfStockProducts() throws SQLException;
}
