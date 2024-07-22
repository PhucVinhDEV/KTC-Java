package Dao;

import Enity.Staff;
import Helper.JDBCHelper;
import Utils.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class StaffDAO {
    private static final String LOGINSQL = "SELECT * FROM Staff WHERE Username=? AND Password=?";
    private static final String QUERY_PERMISSIONS_BY_USERNAME =
            "SELECT p.permissionname \n" +
                    "                    FROM Staff s \n" +
                    "                    JOIN Role_Staff rs ON s.Username = rs.Username\n" +
                    "                    JOIN role r on rs.roleid = r.roleid\n" +
                    "                    JOIN Role_Permission rp ON r.roleid = rp.roleid \n" +
                    "                    JOIN Permission p ON rp.permissionid = p.permissionid \n" +
                    "                    WHERE s.Username = ?";
    private static final String INSERT_STAFF_SQL = "INSERT INTO Staff (Username, Password, Name) VALUES (?, ?, ?)";

    public void login(String username, String password) {
        Auth auth = new Auth();
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGINSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, Base64.getEncoder().encodeToString(password.getBytes()));


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("Username");
                String pass = resultSet.getString("Password");
                String name = resultSet.getString("Name");
                Staff staff = new Staff(user, pass, name);
                auth.setUser(staff);

                // Fetch permissions
                List<String> permissions = getPermissionsByUsername(connection, username);
                auth.setPermissions(permissions);
                System.out.println("Login succesfully");
            }else {
                System.out.println("Login fail !! ");
            }
            System.out.println("Login " + Auth.isLogin());
            System.out.println("Permision " + Auth.getPermissions());
             // Nếu có kết quả trả về, trả về true (đăng nhập thành công)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<String> getPermissionsByUsername(Connection connection, String username) {
        List<String> permissions = new ArrayList<>();

        try (PreparedStatement permissionStatement = connection.prepareStatement(QUERY_PERMISSIONS_BY_USERNAME)) {
            permissionStatement.setString(1, username);
            ResultSet resultSet = permissionStatement.executeQuery();

            while (resultSet.next()) {
                permissions.add(resultSet.getString("PermissionName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return permissions;
    }

    public void insertStaff(Staff staff) {
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(INSERT_STAFF_SQL);
            insertStatement.setString(1, staff.getUsername());
            insertStatement.setString(2,staff.getPassword());
            insertStatement.setString(3, staff.getName());

            insertStatement.executeUpdate();
            System.out.println("Insert" + staff.getUsername() + " Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
