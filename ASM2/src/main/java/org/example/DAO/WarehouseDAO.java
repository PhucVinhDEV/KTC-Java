package org.example.DAO;


import org.example.Entity.WareHouse;
import org.example.Utils.SuperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAO extends SuperDAO<WareHouse, String> {
    @Override
    protected WareHouse mapRowToEntity(ResultSet rs) throws SQLException {
        WareHouse warehouse = new WareHouse();
        warehouse.setWarehouseId(rs.getString("WAREHOUSE_ID"));
        warehouse.setWarehouseName(rs.getString("WAREHOUSE_NAME"));
        return warehouse;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, WareHouse warehouse) throws SQLException {
        ps.setString(1, warehouse.getWarehouseId());
        ps.setString(2, warehouse.getWarehouseName());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, WareHouse warehouse) throws SQLException {
        ps.setString(1, warehouse.getWarehouseName());
        ps.setString(2, warehouse.getWarehouseId());
    }

    @Override
    protected String getTableName() {
        return "Warehouse";
    }

    @Override
    protected String getColumnNames() {
        return "WAREHOUSE_ID, WAREHOUSE_NAME";
    }

    @Override
    protected String getIdColumnName() {
        return "WAREHOUSE_ID";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "";
    }


        public WareHouse findByWarehouseName(String warehouseName) {
            WareHouse warehouse = null;
            String sql = "SELECT * FROM " + getTableName() + " WHERE WAREHOUSE_NAME = ?";

            try (Connection conn = jdbcHelper.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, warehouseName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    warehouse = mapRowToEntity(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return warehouse;
        }
    public List<WareHouse> findWarehousesWithoutUsers() {
        List<WareHouse> warehouses = new ArrayList<>();
        String sql = "SELECT w.warehouse_id, w.warehouse_name " +
                "FROM warehouse w " +
                "LEFT JOIN account_warehouse aw ON w.warehouse_id = aw.warehouse_id " +
                "WHERE aw.account_id IS NULL";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                WareHouse warehouse = new WareHouse();
                warehouse.setWarehouseId(rs.getString("warehouse_id"));
                warehouse.setWarehouseName(rs.getString("warehouse_name"));
                warehouses.add(warehouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return warehouses;
    }
}

