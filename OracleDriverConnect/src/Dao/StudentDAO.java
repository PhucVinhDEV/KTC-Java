package Dao;

import Enity.Student;
import Enity.StudentAttendance;
import Helper.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class StudentDAO {
    private static final String INSERT_STUDENT_SQL = "INSERT INTO Student ( Name) VALUES (?)";
    private static final String GET_ALL_STUDENTS_SQL = "SELECT * FROM Student";



    public void insertStudent(String studentName) throws SQLException {
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(GET_ALL_STUDENTS_SQL);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ST_ID");
                String name = resultSet.getString("Name");
                Student student = new Student(id, name);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
