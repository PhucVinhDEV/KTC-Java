package org.example.DAO;


import org.example.Entity.Product;
import org.example.Utils.SuperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends SuperDAO<Product, String> {
    @Override
    protected Product mapRowToEntity(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString("PRODUCT_ID"));
        product.setProductName(rs.getString("PRODUCT_NAME"));
        product.setWarehouseId(rs.getString("WAREHOUSE_ID"));
        return product;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Product product) throws SQLException {
        ps.setString(1, product.getProductId());
        ps.setString(2, product.getProductName());
        ps.setString(3, product.getWarehouseId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Product product) throws SQLException {
        ps.setString(1, product.getProductName());
        ps.setString(2, product.getWarehouseId());
        ps.setString(3, product.getProductId());
    }

    @Override
    protected String getTableName() {
        return "Product";
    }

    @Override
    protected String getColumnNames() {
        return "PRODUCT_ID, PRODUCT_NAME, WAREHOUSE_ID";
    }

    @Override
    protected String getIdColumnName() {
        return "PRODUCT_ID";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "";
    }

    public List<Product> findProductByProductName(String productName) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE PRODUCT_NAME = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, productName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(mapRowToEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
