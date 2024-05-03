package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;

public interface ProductDao {
	
	List<Product> findAllProducts() throws SQLException;

    Product findProductById(int productId) throws SQLException;

    int addProduct(Product product) throws SQLException;

    int updateProduct(Product product) throws SQLException;

    int deleteProduct(int productId) throws SQLException;
    
    int getProductQuantity(int productId) throws SQLException;
}
