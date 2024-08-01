package org.example.DAO;


import org.example.Entity.ProductAttributeInteger;
import org.example.Utils.SuperDAO;
import org.example.Utils.SuperEAVDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductAttributeIntegerDAO extends SuperEAVDAO<ProductAttributeInteger, String> {


    @Override
    protected ProductAttributeInteger mapRowToEntity(ResultSet rs) throws SQLException {
        ProductAttributeInteger attribute = new ProductAttributeInteger();
        attribute.setProductId(rs.getString("PRODUCT_ID"));
        attribute.setAttributeId(rs.getString("ATTRIBUTE_ID"));
        attribute.setAttributeValue(rs.getInt("ATTRIBUTE_VALUE"));
        return attribute;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, ProductAttributeInteger attribute) throws SQLException {
        ps.setString(1, attribute.getProductId());
        ps.setString(2, attribute.getAttributeId());
        ps.setInt(3, attribute.getAttributeValue());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, ProductAttributeInteger attribute) throws SQLException {
        ps.setInt(1, attribute.getAttributeValue());
        ps.setString(2, attribute.getProductId());
        ps.setString(3, attribute.getAttributeId());
    }

    @Override
    protected String getTableName() {
        return "Product_Attribute_Integer";
    }

    @Override
    protected String getColumnNames() {
        return "PRODUCT_ID, ATTRIBUTE_ID, ATTRIBUTE_VALUE";
    }

    @Override
    protected String getIdColumnName() {
        return "PRODUCT_ID, ATTRIBUTE_ID";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "";
    }

    public void deleteProductAttributeInt(String productId, String attributeId) {
        String query = "DELETE FROM Product_Attribute_Int WHERE ProductID = ? AND AttributeID = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, productId);
            ps.setString(2, attributeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
