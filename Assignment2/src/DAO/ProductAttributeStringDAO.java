package DAO;

import Entity.ProductAttributeString;
import Utils.SuperDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductAttributeStringDAO extends SuperDAO<ProductAttributeString, String> {

    @Override
    protected ProductAttributeString mapRowToEntity(ResultSet rs) throws SQLException {
        ProductAttributeString attribute = new ProductAttributeString();
        attribute.setProductId(rs.getString("PRODUCT_ID"));
        attribute.setAttributeId(rs.getString("ATTRIBUTE_ID"));
        attribute.setAttributeValue(rs.getString("ATTRIBUTE_VALUE"));
        return attribute;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, ProductAttributeString attribute) throws SQLException {
        ps.setString(1, attribute.getProductId());
        ps.setString(2, attribute.getAttributeId());
        ps.setString(3, attribute.getAttributeValue());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, ProductAttributeString attribute) throws SQLException {
        ps.setString(1, attribute.getAttributeValue());
        ps.setString(2, attribute.getProductId());
        ps.setString(3, attribute.getAttributeId());
    }

    @Override
    protected String getTableName() {
        return "Product_Attribute_String";
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
