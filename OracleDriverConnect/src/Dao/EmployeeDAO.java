package Dao;

import Enity.Employee;
import Helper.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public void readEmployeeByID(int employeeId) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int empId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String hireDate = rs.getString("hire_date");
                String jobId = rs.getString("job_id");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID: " + empId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Hire Date: " + hireDate);
                System.out.println("Job ID: " + jobId);
                System.out.println("Salary: " + salary);
            } else {
                System.out.println("Employee not found with ID: " + employeeId);
            }

        } catch (SQLException e) {
            System.out.println("Error reading employee: " + e.getMessage());
        }
    }

    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id, salary) "
                + "VALUES (employees_seq.nextval, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getHireDate());
            stmt.setString(5, employee.getJobId());
            stmt.setDouble(6, employee.getSalary());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    public void updateEmployee(int employeeId, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE employee_id = ?";

        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newSalary);
            stmt.setInt(2, employeeId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }

        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployeeById(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
