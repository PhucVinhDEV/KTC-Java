package DAO;

import Entity.ProductAttributeBigDecimal;
import Utils.SuperDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductAttributeBigDecimalDAO extends SuperDAO<ProductAttributeBigDecimal, String> {
    @Override
    protected ProductAttributeBigDecimal mapRowToEntity(ResultSet rs) throws SQLException {
        ProductAttributeBigDecimal attribute = new ProductAttributeBigDecimal();
        attribute.setProductId(rs.getString("PRODUCT_ID"));
        attribute.setAttributeId(rs.getString("ATTRIBUTE_ID"));
        attribute.setAttributeValue(rs.getBigDecimal("ATTRIBUTE_VALUE"));
        return attribute;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, ProductAttributeBigDecimal attribute) throws SQLException {
        ps.setString(1, attribute.getProductId());
        ps.setString(2, attribute.getAttributeId());
        ps.setBigDecimal(3, attribute.getAttributeValue());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, ProductAttributeBigDecimal attribute) throws SQLException {
        ps.setBigDecimal(1, attribute.getAttributeValue());
        ps.setString(2, attribute.getProductId());
        ps.setString(3, attribute.getAttributeId());
    }

    @Override
    protected String getTableName() {
        return "Product_Attribute_BigDecimal";
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
}
