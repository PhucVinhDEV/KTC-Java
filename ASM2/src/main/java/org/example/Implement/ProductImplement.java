package org.example.Implement;

import org.example.DAO.ProductDAO;
import org.example.Entity.Product;
import org.example.Service.ProductService;

import java.util.List;

public class ProductImplement implements ProductService {
    private ProductDAO productDAO = new ProductDAO();


    @Override
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product findProductById(String productId) {
        return productDAO.findById(productId);
    }

    @Override
    public Product findProductByProductName(String productname) {
        return productDAO.findProductByProductName(productname).get(0);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productDAO.delete(productId);
    }
}
