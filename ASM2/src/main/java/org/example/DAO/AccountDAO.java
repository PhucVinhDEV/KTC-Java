package org.example.DAO;


import org.example.Entity.Account;
import org.example.Utils.SuperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static org.example.Helper.JDBCHelper.getConnection;

public class AccountDAO extends SuperDAO<Account,String> {
    @Override
    protected Account mapRowToEntity(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setUsername(rs.getString("USERNAME"));
        account.setPassword(rs.getString("PASSWORD"));
        account.setEmail(rs.getString("Email"));
        account.setIsAdmin(rs.getInt("IsAdmin"));
        return account;
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Account account) throws SQLException {
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setInt(4, account.getIsAdmin());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Account account) throws SQLException {
        ps.setString(1, account.getPassword());
        ps.setString(2, account.getEmail());
        ps.setInt(3, account.getIsAdmin());
        ps.setString(4, account.getUsername());
    }

    @Override
    protected String getTableName() {
        return "account";
    }

    @Override
    protected String getColumnNames() {
        return "username, password, Email, isAdmin";
    }

    @Override
    protected String getIdColumnName() {
        return "USERNAME";
    }

    @Override
    protected String getPlaceholders() {
        return "?, ?, ?, ?";
    }

    @Override
    protected String getUpdateColumnNames() {
        return "password = ?, email = ?, isAdmin = ?";
    }

    public Account findByEmail(String email) {
        Account account = null;
        String sql = "SELECT * FROM " + getTableName() + " WHERE Email = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    account = mapRowToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., log the error, rethrow as a runtime exception, etc.)
        }

        return account;
    }
}
