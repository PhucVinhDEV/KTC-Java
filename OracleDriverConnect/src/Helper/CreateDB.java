package Helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static Utils.OracleUtil.SQL_CREATE_DB;

public class CreateDB {
    public void createEmployeeTable(Connection conn) {
        String sql = "CREATE TABLE Employees (" +
                "    employee_id NUMBER PRIMARY KEY," +
                "    first_name VARCHAR2(50)," +
                "    last_name VARCHAR2(50)," +
                "    email VARCHAR2(100)," +
                "    hire_date DATE," +
                "    job_id VARCHAR2(20)," +
                "    salary NUMBER(10, 2)" +
                ")";
        // Câu lệnh SQL tạo sequence employees_seq
        String createSequenceSQL = "CREATE SEQUENCE employees_seq START WITH 1 INCREMENT BY 1";

        try (Statement stmt = conn.createStatement()) {
            // Execute the SQL statement
            stmt.execute(sql);
            System.out.println("Table 'Employees' created successfully.");
            stmt.execute(createSequenceSQL);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public void createDB(Connection conn) {
        String sql = SQL_CREATE_DB;
        // Câu lệnh SQL tạo sequence employees_seq
        String createSequenceSQL = "CREATE SEQUENCE employees_seq START WITH 1 INCREMENT BY 1";

        try (Statement stmt = conn.createStatement()) {
            // Execute the SQL statement
            stmt.execute(sql);
            System.out.println("Table 'Employees' created successfully.");
            stmt.execute(createSequenceSQL);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
}
