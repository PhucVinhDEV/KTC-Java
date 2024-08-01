package DAO;

import Entity.Attribute;
import Utils.SuperDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttributeDAO  extends SuperDAO<Attribute, String> {
    @Override
    protected Attribute mapRowToEntity(ResultSet rs) throws SQLException {
        Attribute attribute = new Attribute();
        attribute.setAttributeId(rs.getString("ATTRIBUTE_ID"));
        attribute.setAttributeName(rs.getString("ATTRIBUTE_NAME"));
        return attribute;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Attribute attribute) throws SQLException {
        ps.setString(1, attribute.getAttributeId());
        ps.setString(2, attribute.getAttributeName());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Attribute attribute) throws SQLException {
        ps.setString(1, attribute.getAttributeName());
        ps.setString(2, attribute.getAttributeId());
    }

    @Override
    protected String getTableName() {
        return "Attribute";
    }

    @Override
    protected String getColumnNames() {
        return "ATTRIBUTE_ID, ATTRIBUTE_NAME";
    }

    @Override
    protected String getIdColumnName() {
        return "ATTRIBUTE_ID";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "";
    }
}
