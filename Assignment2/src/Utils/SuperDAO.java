package Utils;

import Helper.JDBCHelper;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperDAO<T, ID extends Serializable> {

    private final Class<T> persistentClass;
    protected JDBCHelper jdbcHelper;

    @SuppressWarnings("unchecked")
    public SuperDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.jdbcHelper = new JDBCHelper();
    }

    protected abstract T mapRowToEntity(ResultSet rs) throws SQLException;
    protected abstract void setInsertParams(PreparedStatement ps, T entity) throws SQLException;
    protected abstract void setUpdateParams(PreparedStatement ps, T entity) throws SQLException;

    public void save(T entity) {
        String sql = "INSERT INTO " + getTableName() + " (" + getColumnNames() + ") VALUES (" + getPlaceholders() + ")"; // Adjust the number of placeholders
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setInsertParams(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T findById(ID id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        }
        return entities;
    }

    public void update(T entity) {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateColumnNames() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setUpdateParams(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ID id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        try (Connection conn = jdbcHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getTableName();
    protected abstract String getColumnNames();
    protected abstract String getIdColumnName();
    protected abstract String getPlaceholders();
    protected abstract String getUpdateColumnNames();
}
