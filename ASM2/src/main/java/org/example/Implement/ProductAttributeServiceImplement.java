package org.example.Implement;

import org.example.DAO.ProductAttributeBigDecimalDAO;
import org.example.DAO.ProductAttributeDateDAO;
import org.example.DAO.ProductAttributeIntegerDAO;
import org.example.DAO.ProductAttributeStringDAO;
import org.example.Entity.ProductAttributeBigDecimal;
import org.example.Entity.ProductAttributeDate;
import org.example.Entity.ProductAttributeInteger;
import org.example.Entity.ProductAttributeString;
import org.example.Service.ProductAttributeService;

import java.util.List;

public class ProductAttributeServiceImplement implements ProductAttributeService {
    private ProductAttributeBigDecimalDAO productAttributeBigDecimalDAO;
    private ProductAttributeDateDAO productAttributeDateDAO;
    private ProductAttributeIntegerDAO productAttributeIntDAO;
    private ProductAttributeStringDAO productAttributeStringDAO;

    public ProductAttributeServiceImplement() {
        this.productAttributeBigDecimalDAO = new ProductAttributeBigDecimalDAO();
        this.productAttributeDateDAO = new ProductAttributeDateDAO();
        this.productAttributeIntDAO = new ProductAttributeIntegerDAO();
        this.productAttributeStringDAO = new ProductAttributeStringDAO();
    }

    // BigDecimal
    @Override
    public void saveProductAttributeBigDecimal(ProductAttributeBigDecimal productAttribute) {
        productAttributeBigDecimalDAO.save(productAttribute);
    }

    @Override
    public ProductAttributeBigDecimal findProductAttributeBigDecimalById(String productId, String attributeId) {
        return productAttributeBigDecimalDAO.findById(productId, attributeId);
    }

    @Override
    public List<ProductAttributeBigDecimal> findAllProductAttributesBigDecimal() {
        return productAttributeBigDecimalDAO.findAll();
    }

    @Override
    public void updateProductAttributeBigDecimal(ProductAttributeBigDecimal productAttribute) {
        productAttributeBigDecimalDAO.update(productAttribute);
    }

    @Override
    public void deleteProductAttributeBigDecimal(String productId, String attributeId) {
        productAttributeBigDecimalDAO.deleteProductAttributeBigDecimal(productId, attributeId);
    }

    // Date
    @Override
    public void saveProductAttributeDate(ProductAttributeDate productAttribute) {
        productAttributeDateDAO.save(productAttribute);
    }

    @Override
    public ProductAttributeDate findProductAttributeDateById(String productId, String attributeId) {
        return productAttributeDateDAO.findById(productId, attributeId);
    }

    @Override
    public List<ProductAttributeDate> findAllProductAttributesDate() {
        return productAttributeDateDAO.findAll();
    }

    @Override
    public void updateProductAttributeDate(ProductAttributeDate productAttribute) {
        productAttributeDateDAO.update(productAttribute);
    }

    @Override
    public void deleteProductAttributeDate(String productId, String attributeId) {
        productAttributeDateDAO.deleteProductAttributeDate(productId, attributeId);
    }

    // Int
    @Override
    public void saveProductAttributeInt(ProductAttributeInteger productAttribute) {
        productAttributeIntDAO.save(productAttribute);
    }

    @Override
    public ProductAttributeInteger findProductAttributeIntById(String productId, String attributeId) {
        return productAttributeIntDAO.findById(productId, attributeId);
    }

    @Override
    public List<ProductAttributeInteger> findAllProductAttributesInt() {
        return productAttributeIntDAO.findAll();
    }

    @Override
    public void updateProductAttributeInt(ProductAttributeInteger productAttribute) {
        productAttributeIntDAO.update(productAttribute);
    }

    @Override
    public void deleteProductAttributeInt(String productId, String attributeId) {
        productAttributeIntDAO.deleteProductAttributeInt(productId, attributeId);
    }

    // String
    @Override
    public void saveProductAttributeString(ProductAttributeString productAttribute) {
        productAttributeStringDAO.save(productAttribute);
    }

    @Override
    public ProductAttributeString findProductAttributeStringById(String productId, String attributeId) {
        return productAttributeStringDAO.findById(productId, attributeId);
    }

    @Override
    public List<ProductAttributeString> findAllProductAttributesString() {
        return productAttributeStringDAO.findAll();
    }

    @Override
    public void updateProductAttributeString(ProductAttributeString productAttribute) {
        productAttributeStringDAO.update(productAttribute);
    }

    @Override
    public void deleteProductAttributeString(String productId, String attributeId) {
        productAttributeStringDAO.deleteProductAttributeString(productId, attributeId);
    }
}
