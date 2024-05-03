package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.daoImpl.*;
import com.model.Product;

public class ProductService {
ProductDao productDao = new ProductDaoImpl();
	 public List<Product> getAllProducts() throws SQLException {
	        return productDao.findAllProducts();
	    }

	    public Product getProductById(int productId) throws SQLException {
	        return productDao.findProductById(productId);
	    }

	    public void addProduct(Product product) throws SQLException {
	        productDao.addProduct(product);
	    }

	    public void updateProduct(Product product) throws SQLException {
	        productDao.updateProduct(product);
	    }

	    public void deleteProduct(int productId) throws SQLException {
	        productDao.deleteProduct(productId);
	    }
	    public int getProductQuantity(int productId) throws SQLException {
	        return productDao.getProductQuantity(productId);
	    }
}
