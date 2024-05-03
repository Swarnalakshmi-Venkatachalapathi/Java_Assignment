package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.model.Product;
import com.utility.DBConfig;

public class ProductDaoImpl implements ProductDao {
	
    @Override
    public List<Product> findAllProducts() throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT * FROM Products";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Product> productList = new ArrayList<>();
        while (rs.next()) {
            int productId = rs.getInt("ProductID");
            String productName = rs.getString("ProductName");
            String description = rs.getString("Description");
            double price = rs.getDouble("Price");
            int quantity = rs.getInt("Quantity");
            Product product = new Product(productId, productName, description, price, quantity);
            productList.add(product);
        }
        DBConfig.dbClose();
        return productList;
    }

    @Override
    public Product findProductById(int productId) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, productId);
        ResultSet rs = pstmt.executeQuery();

        Product product = null;
        while (rs.next()) {
            String productName = rs.getString("ProductName");
            String description = rs.getString("Description");
            double price = rs.getDouble("Price");
            int quantity = rs.getInt("Quantity");
            product = new Product(productId, productName, description, price, quantity);
        }
        DBConfig.dbClose();
        return product;
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "INSERT INTO Products (ProductName, Description, Price,Qnatity) VALUES (?, ?, ?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, product.getProductName());
        pstmt.setString(2, product.getDescription());
        pstmt.setDouble(3, product.getPrice());
        pstmt.setInt(4, product.getQuantity());
        int status = pstmt.executeUpdate();
        DBConfig.dbClose();
        return status;
    }

    @Override
    public int updateProduct(Product product) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "UPDATE Products SET ProductName=?, Description=?, Price=?,Quantity=? WHERE ProductID=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, product.getProductName());
        pstmt.setString(2, product.getDescription());
        pstmt.setDouble(3, product.getPrice());
        pstmt.setInt(4, product.getQuantity());
        pstmt.setInt(5, product.getProductID());
        int status = pstmt.executeUpdate();
        DBConfig.dbClose();
        return status;
    }

    @Override
    public int deleteProduct(int productId) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "DELETE FROM Products WHERE ProductID=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, productId);
        int status = pstmt.executeUpdate();
        DBConfig.dbClose();
        return status;
    }
    
    @Override
    public int getProductQuantity(int productId) throws SQLException {
        Connection con = DBConfig.dbConnect();
        String sql = "SELECT Quantity FROM Products WHERE ProductID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, productId);
        ResultSet rs = pstmt.executeQuery();

        int quantity = 0;
        if (rs.next()) {
            quantity = rs.getInt("Quantity");
        }
        DBConfig.dbClose();
        return quantity;
    }
}
