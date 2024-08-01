package DAO;

import Entity.Product;
import Utils.SuperDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
