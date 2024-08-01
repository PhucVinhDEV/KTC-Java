package DAO;

import DTO.WarehouseAccountReponseeDTO;
import Entity.Account;
import Entity.AccountWarehouse;
import Utils.SuperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountWarehouseDAO extends SuperDAO<AccountWarehouse,String> {

    @Override
    protected AccountWarehouse mapRowToEntity(ResultSet rs) throws SQLException {
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        accountWarehouse.setAccountId(rs.getString("account_id"));
        accountWarehouse.setWarehouseId(rs.getString("warehouse_id"));
        return accountWarehouse;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, AccountWarehouse entity) throws SQLException {
        ps.setString(1, entity.getAccountId());
        ps.setString(2, entity.getWarehouseId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, AccountWarehouse entity) throws SQLException {
        ps.setString(1, entity.getWarehouseId());
        ps.setString(2, entity.getAccountId());
    }

    @Override
    protected String getTableName() {
        return "account_warehouse";
    }

    @Override
    protected String getColumnNames() {
        return "account_id, warehouse_id";
    }

    @Override
    protected String getIdColumnName() {
        return "account_id";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "warehouse_id = ?";
    }

    public List<WarehouseAccountReponseeDTO> readWareHouse() {
        List<WarehouseAccountReponseeDTO> accountWarehouses = new ArrayList<>();
        String sql = "SELECT account.username, account.email, warehouse.warehouse_name, account_warehouse.warehouse_id " +
                "FROM account_warehouse " +
                "JOIN account ON account_warehouse.account_id = account.username " +
                "JOIN warehouse ON warehouse.warehouse_id = account_warehouse.warehouse_id";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                WarehouseAccountReponseeDTO dto = new WarehouseAccountReponseeDTO();
                dto.setUsername(rs.getString("username"));
                dto.setEmail(rs.getString("email"));
                dto.setWarehouseName(rs.getString("warehouse_name"));
                dto.setWarehouseId(rs.getString("warehouse_id"));
                accountWarehouses.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountWarehouses;
    }

    public void delete(String accountId, String warehouseId) {
        String sql = "DELETE FROM account_warehouse WHERE account_id = ? AND warehouse_id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountId);
            ps.setString(2, warehouseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountWarehouseWithAccountId(String accountId) {
        String sql = "DELETE FROM account_warehouse WHERE account_id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountWarehouseWithWarehouseId(String warehouseId) {
        String sql = "DELETE FROM account_warehouse WHERE warehouse_id = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, warehouseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
