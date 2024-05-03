package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.daoImpl.*;
import com.model.Inventry;
import com.model.Product;
public class InventryService {
	InventryDao inventoryDao = new InvertryDaoImpl();
	public Inventry getProduct(int inventoryID) throws SQLException {
        return inventoryDao.getProduct(inventoryID);
    }

    public int getQuantityInStock(int inventoryID) throws SQLException {
        return inventoryDao.getQuantityInStock(inventoryID);
    }

    public void addToInventory(int inventoryID, int quantityToAdd) throws SQLException {
        inventoryDao.addToInventory(inventoryID, quantityToAdd);
    }

    public void removeFromInventory(int inventoryID, int quantityToRemove) throws SQLException {
        inventoryDao.removeFromInventory(inventoryID, quantityToRemove);
    }

    public void updateStockQuantity(int inventoryID, int newQuantity) throws SQLException {
        inventoryDao.updateStockQuantity(inventoryID, newQuantity);
    }

    public boolean isProductAvailable(int inventoryID, int quantityToCheck) throws SQLException {
        return inventoryDao.isProductAvailable(inventoryID, quantityToCheck);
    }

    public double getInventoryValue() throws SQLException {
        return inventoryDao.getInventoryValue();
    }
    public List<Product> listLowStockProducts(int threshold) throws SQLException {
        return inventoryDao.getLowStockProducts(threshold);
    }


    public List<Product> listOutOfStockProducts() throws SQLException {
        return inventoryDao.getOutOfStockProducts();
      
    }
/*
    public void listLowStockProducts(int threshold) throws SQLException {
        List<Inventry> lowStockProducts = inventoryDao.listLowStockProducts(threshold);
        for (Inventry inventory : lowStockProducts) {
            System.out.println(inventory.getProduct());
        }
    }

    public void listOutOfStockProducts() throws SQLException {
        List<Inventry> outOfStockProducts = inventoryDao.listOutOfStockProducts();
        for (Inventry inventory : outOfStockProducts) {
            System.out.println(inventory.getProduct());
        }
    }*/
}
