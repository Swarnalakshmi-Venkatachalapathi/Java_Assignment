package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.InventryDao;
import com.model.Inventry;
import com.model.Product;
import com.utility.DBConfig;

public class InvertryDaoImpl implements InventryDao {


    @Override
    public Inventry getProduct(int inventoryID) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT * FROM Inventory WHERE InventoryID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, inventoryID);
        ResultSet rs = pstmt.executeQuery();
        Inventry inventory = null;
        if (rs.next()) {
            inventory = new Inventry();
            inventory.setInventoryID(rs.getInt("InventoryID"));
            inventory.setProduct(rs.getInt("ProductID"));
            inventory.setQuantityInStock(rs.getInt("Quantity"));
            inventory.setLastStockUpdate(rs.getTimestamp("LastStockUpdate"));
        }
        DBConfig.dbClose();
        return inventory;
    }

    @Override
    public int getQuantityInStock(int inventoryID) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT Quantity FROM Inventory WHERE InventoryID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, inventoryID);
        ResultSet rs = pstmt.executeQuery();
        int quantity = 0;
        if (rs.next()) {
            quantity = rs.getInt("Quantity");
        }
        DBConfig.dbClose();
        return quantity;
    }

    @Override
    public void addToInventory(int inventoryID, int quantityToAdd) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "UPDATE Inventory SET Quantity = Quantity + ? WHERE InventoryID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, quantityToAdd);
        pstmt.setInt(2, inventoryID);
        pstmt.executeUpdate();
        DBConfig.dbClose();
    }

    @Override
    public void removeFromInventory(int inventoryID, int quantityToRemove) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "UPDATE Inventory SET Quantity = Quantity - ? WHERE InventoryID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, quantityToRemove);
        pstmt.setInt(2, inventoryID);
        pstmt.executeUpdate();
        DBConfig.dbClose();
    }

    @Override
    public void updateStockQuantity(int inventoryID, int newQuantity) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "UPDATE Inventory SET Quantity = ? WHERE InventoryID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, newQuantity);
        pstmt.setInt(2, inventoryID);
        pstmt.executeUpdate();
        DBConfig.dbClose();
    }

    @Override
    public boolean isProductAvailable(int inventoryID, int quantityToCheck) throws SQLException {
        int currentQuantity = getQuantityInStock(inventoryID);
        return currentQuantity >= quantityToCheck;
    }

    @Override
    public double getInventoryValue() throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT SUM(Quantity * Price) AS InventoryValue FROM Inventory i INNER JOIN Products p ON i.ProductID = p.ProductID";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        double value = 0;
        if (rs.next()) {
            value = rs.getDouble("InventoryValue");
        }
        DBConfig.dbClose();
        return value;
    }

    @Override
    public List<Inventry> listLowStockProducts(int threshold) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT * FROM Inventory WHERE Quantity < ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, threshold);
        ResultSet rs = pstmt.executeQuery();
        List<Inventry> lowStockProducts = new ArrayList<>();
        while (rs.next()) {
            Inventry inventory = new Inventry();
            inventory.setInventoryID(rs.getInt("InventoryID"));
            inventory.setProduct(rs.getInt("ProductID"));
            inventory.setQuantityInStock(rs.getInt("Quantity"));
            inventory.setLastStockUpdate(rs.getTimestamp("LastStockUpdate"));
            lowStockProducts.add(inventory);
        }
        DBConfig.dbClose();
        return lowStockProducts;
    }

    @Override
    public List<Inventry> listOutOfStockProducts() throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT * FROM Inventory WHERE Quantity = 0";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Inventry> outOfStockProducts = new ArrayList<>();
        while (rs.next()) {
            Inventry inventory = new Inventry();
            inventory.setInventoryID(rs.getInt("InventoryID"));
            inventory.setProduct(rs.getInt("ProductID"));
            inventory.setQuantityInStock(rs.getInt("Quantity"));
            inventory.setLastStockUpdate(rs.getTimestamp("LastStockUpdate"));
            outOfStockProducts.add(inventory);
        }
        DBConfig.dbClose();
        return outOfStockProducts;
    }
    
    @Override
    public List<Product> getOutOfStockProducts() throws SQLException {

            Connection con = DBConfig.dbConnect();
            String sql = "SELECT * FROM inventory WHERE Quantity = 0";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Product> outOfStockProducts = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                // Set other product attributes as needed
                outOfStockProducts.add(product);
            }
       
            DBConfig.dbClose();
        
        return outOfStockProducts;
    }
    
    @Override
    public List<Product> getLowStockProducts(int threshold) throws SQLException {
       
        List<Product> lowStockProducts = new ArrayList<>();

       
            Connection con = DBConfig.dbConnect();
            String sql = "SELECT * FROM inventory WHERE Quantity < ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, threshold);
            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Product product = new Product();
                product.setProductID(rst.getInt("ProductID"));
                // Set other product attributes as needed
                lowStockProducts.add(product);
            }
     
            DBConfig.dbClose();
        
        return lowStockProducts;
    }

}
