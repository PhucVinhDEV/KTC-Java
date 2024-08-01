package org.example.Utils;

import org.example.Helper.JDBCHelper;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperEAVDAO<T, ID extends Serializable> {

    protected JDBCHelper jdbcHelper;

    public SuperEAVDAO() {
        this.jdbcHelper = new JDBCHelper();
    }

    protected abstract T mapRowToEntity(ResultSet rs) throws SQLException;

    protected abstract void setInsertParams(PreparedStatement ps, T entity) throws SQLException;

    protected abstract void setUpdateParams(PreparedStatement ps, T entity) throws SQLException;

    protected abstract String getTableName();

    protected abstract String getColumnNames();

    protected abstract String getIdColumnName();

    protected abstract String getPlaceholders();

    protected abstract String getUpdateColumnNames();

    public void save(T entity) {
        String sql = "INSERT INTO " + getTableName() + " (" + getColumnNames() + ") VALUES (" + getPlaceholders() + ")";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setInsertParams(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHelper.disconnect();
        }
    }

    public T findById(ID id1, ID id2) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ? AND " + getIdColumnName().split(", ")[1] + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id1);
            ps.setObject(2, id2);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHelper.disconnect();
        }
        return null;
    }

    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                entities.add(mapRowToEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHelper.disconnect();
        }
        return entities;
    }

    public void update(T entity) {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateColumnNames() + " WHERE " + getIdColumnName().split(", ")[0] + " = ? AND " + getIdColumnName().split(", ")[1] + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setUpdateParams(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHelper.disconnect();
        }
    }

    public void delete(ID id1, ID id2) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ? AND " + getIdColumnName().split(", ")[1] + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id1);
            ps.setObject(2, id2);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHelper.disconnect();
        }
    }
}
