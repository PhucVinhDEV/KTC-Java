package Dao;

import DTO.AttendanceDTO;
import Enity.StudentAttendance;
import Helper.JDBCHelper;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceDAO {
    private static final String INSERT_STUDENT_ATTENDANCE_SQL =
            "INSERT INTO Student_Advanced (ST_ID, ATTENDANCE_ID, Status) VALUES ( ?, ?, ?)";
    private static final String SELECT_BY_DATE_SQL =
            "SELECT * \n" +
                    "FROM student_advanced a\n" +
                    "JOIN student c ON a.st_id = c.st_id\n" +
                    "JOIN attendance b ON a.attendance_id = b.attendance_id\n" +
                    "WHERE b.attendance_date >= to_timestamp(?, 'dd-mm-yyyy hh24:mi:ss')\n" +
                    "  AND b.attendance_date <= to_timestamp(?, 'dd-mm-yyyy hh24:mi:ss')";

    public List<AttendanceDTO> selectByDate(String dateString) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        List<AttendanceDTO> attendanceList = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_DATE_SQL);

            // Construct start and end timestamps
            String startDateTimeString = dateString + " 00:00:01";
            String endDateTimeString = dateString + " 23:59:59";
            Timestamp startTimestamp = new Timestamp(dateFormatter.parse(startDateTimeString).getTime());
            Timestamp endTimestamp = new Timestamp(dateFormatter.parse(endDateTimeString).getTime());

            System.out.println("startDateTimeString: " + startDateTimeString);
            System.out.println("endDateTimeString: " + endDateTimeString);

            // Set parameters in the prepared statement
            preparedStatement.setString(1, startDateTimeString);
            preparedStatement.setString(2, endDateTimeString);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {



                String studentName = resultSet.getString("name");
                boolean status = resultSet.getBoolean("status");
                String username = resultSet.getString("username");

                AttendanceDTO attendanceDTO = new AttendanceDTO(studentName, username, status);
                attendanceList.add(attendanceDTO);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    public void insertStudentAttendance (StudentAttendance studentAttendance){
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_ATTENDANCE_SQL);

            // Đặt các giá trị cho PreparedStatement từ đối tượng StudentAttendance
            preparedStatement.setInt(1, studentAttendance.getStudentID());
            preparedStatement.setInt(2, studentAttendance.getAttendance());
            preparedStatement.setBoolean(3, studentAttendance.getStatus());

            preparedStatement.executeUpdate();
            System.out.println("Student attendance inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
