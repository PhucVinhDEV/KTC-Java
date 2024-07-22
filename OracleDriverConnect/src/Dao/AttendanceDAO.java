package Dao;

import Enity.Attendance;
import Helper.JDBCHelper;
import Utils.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AttendanceDAO {


    private static final String INSERT_ATTENDANCE_SQL =
            "INSERT INTO Attendance (Attendance_ID, Attendance_Date, Username) VALUES (?, ?, ?)";

    public void insertAttendance(Attendance attendance) {
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ATTENDANCE_SQL);
            preparedStatement.setInt(1, attendance.getAttendanceId());
            preparedStatement.setTimestamp(2, new Timestamp(attendance.getAttendanceDate().getTime()));
            preparedStatement.setString(3, attendance.getUsername());

            preparedStatement.executeUpdate();
            System.out.println("Attendance inserted successfully for username: " + attendance.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
