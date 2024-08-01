package org.example.DAO;



import org.example.Entity.ProductAttributeDate;
import org.example.Utils.SuperDAO;
import org.example.Utils.SuperEAVDAO;

import java.sql.*;


public class ProductAttributeDateDAO extends SuperEAVDAO<ProductAttributeDate, String> {
    @Override
    protected ProductAttributeDate mapRowToEntity(ResultSet rs) throws SQLException {
        ProductAttributeDate attribute = new ProductAttributeDate();
        attribute.setProductId(rs.getString("PRODUCT_ID"));
        attribute.setAttributeId(rs.getString("ATTRIBUTE_ID"));
        attribute.setAttributeValue(rs.getDate("ATTRIBUTE_VALUE"));
        return attribute;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, ProductAttributeDate attribute) throws SQLException {
        ps.setString(1, attribute.getProductId());
        ps.setString(2, attribute.getAttributeId());
        ps.setDate(3, new Date(attribute.getAttributeValue().getTime()));
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, ProductAttributeDate attribute) throws SQLException {
        ps.setDate(1, new Date(attribute.getAttributeValue().getTime()));
        ps.setString(2, attribute.getProductId());
        ps.setString(3, attribute.getAttributeId());
    }

    @Override
    protected String getTableName() {
        return "Product_Attribute_Date";
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

    public void deleteProductAttributeDate(String productId, String attributeId) {
        String query = "DELETE FROM Product_Attribute_Date WHERE ProductID = ? AND AttributeID = ?";
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
