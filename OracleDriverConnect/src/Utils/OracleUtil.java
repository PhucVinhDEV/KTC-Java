package Utils;

public final class OracleUtil {
    public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:oracle";
    public static final String DB_USER = "c##bitznomad";
    public static final String DB_PASSWORD = "123123a";
    public static final String SQL_CREATE_DB = "-- Tạo bảng Student\n" +
            "CREATE TABLE Student (\n" +
            "    ST_ID NUMBER PRIMARY KEY,\n" +
            "    Name VARCHAR2(100) NOT NULL\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Student_Advanced\n" +
            "CREATE TABLE Student_Advanced (\n" +
            "    STAV_ID NUMBER PRIMARY KEY,\n" +
            "    Name VARCHAR2(100) NOT NULL,\n" +
            "    Attendance NUMBER,\n" +
            "    Status VARCHAR2(20),\n" +
            "    CONSTRAINT fk_student_advanced FOREIGN KEY (STAV_ID) REFERENCES Student(ST_ID)\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Staff\n" +
            "CREATE TABLE Staff (\n" +
            "    Username VARCHAR2(50) PRIMARY KEY,\n" +
            "    Password VARCHAR2(100) NOT NULL,\n" +
            "    Name VARCHAR2(100) NOT NULL\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Role\n" +
            "CREATE TABLE Role (\n" +
            "    ID NUMBER PRIMARY KEY,\n" +
            "    RoleName VARCHAR2(50) UNIQUE NOT NULL\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Role_Staff\n" +
            "CREATE TABLE Role_Staff (\n" +
            "    ID NUMBER PRIMARY KEY,\n" +
            "    RoleID NUMBER,\n" +
            "    Username VARCHAR2(50),\n" +
            "    CONSTRAINT fk_role_staff_role FOREIGN KEY (RoleID) REFERENCES Role(ID),\n" +
            "    CONSTRAINT fk_role_staff_staff FOREIGN KEY (Username) REFERENCES Staff(Username)\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Permission\n" +
            "CREATE TABLE Permission (\n" +
            "    PermissionID NUMBER PRIMARY KEY,\n" +
            "    PermissionName VARCHAR2(50) UNIQUE NOT NULL\n" +
            ");\n" +
            "\n" +
            "-- Tạo bảng Role_Permission\n" +
            "CREATE TABLE Role_Permission (\n" +
            "    ID NUMBER PRIMARY KEY,\n" +
            "    Role NUMBER,\n" +
            "    Permission NUMBER,\n" +
            "    CONSTRAINT fk_role_permission_role FOREIGN KEY (Role) REFERENCES Role(ID),\n" +
            "    CONSTRAINT fk_role_permission_permission FOREIGN KEY (Permission) REFERENCES Permission(PermissionID)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE Attendance (\n" +
            "    Attendance_ID NUMBER PRIMARY KEY,\n" +
            "    Attendance_Date DATE NOT NULL,\n" +
            "    Username VARCHAR2(50)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE Attendance\n" +
            "ADD CONSTRAINT fk_attendance_student \n" +
            "FOREIGN KEY (STAV_ID) REFERENCES Student_Advanced(STAV_ID);\n" +
            "\n" +
            "ALTER TABLE Attendance\n" +
            "ADD CONSTRAINT fk_attendance_staff \n" +
            "FOREIGN KEY (Username) REFERENCES Staff(Username);\n" +
            "\n" +
            "-- Tạo sequences cho các primary key tự động tăng\n" +
            "CREATE SEQUENCE seq_student START WITH 1 INCREMENT BY 1;\n" +
            "CREATE SEQUENCE seq_role START WITH 1 INCREMENT BY 1;\n" +
            "CREATE SEQUENCE seq_role_staff START WITH 1 INCREMENT BY 1;\n" +
            "CREATE SEQUENCE seq_permission START WITH 1 INCREMENT BY 1;\n" +
            "CREATE SEQUENCE seq_role_permission START WITH 1 INCREMENT BY 1;\n" +
            "CREATE SEQUENCE seq_attendance START WITH 1 INCREMENT BY 1;\n" +
            "\n" +
            "-- Tạo triggers để tự động tăng primary key\n" +
            "CREATE OR REPLACE TRIGGER trg_student_id\n" +
            "BEFORE INSERT ON Student\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_student.NEXTVAL INTO :NEW.ST_ID FROM DUAL;\n" +
            "END;\n" +
            "/\n" +
            "\n" +
            "CREATE OR REPLACE TRIGGER trg_role_id\n" +
            "BEFORE INSERT ON Role\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_role.NEXTVAL INTO :NEW.ID FROM DUAL;\n" +
            "END;\n" +
            "/\n" +
            "\n" +
            "CREATE OR REPLACE TRIGGER trg_role_staff_id\n" +
            "BEFORE INSERT ON Role_Staff\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_role_staff.NEXTVAL INTO :NEW.ID FROM DUAL;\n" +
            "END;\n" +
            "/\n" +
            "\n" +
            "CREATE OR REPLACE TRIGGER trg_permission_id\n" +
            "BEFORE INSERT ON Permission\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_permission.NEXTVAL INTO :NEW.PermissionID FROM DUAL;\n" +
            "END;\n" +
            "/\n" +
            "\n" +
            "CREATE OR REPLACE TRIGGER trg_role_permission_id\n" +
            "BEFORE INSERT ON Role_Permission\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_role_permission.NEXTVAL INTO :NEW.ID FROM DUAL;\n" +
            "END;\n" +
            "/\n" +
            "\n" +
            "CREATE OR REPLACE TRIGGER trg_attendance_id\n" +
            "BEFORE INSERT ON Attendance\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "    SELECT seq_attendance.NEXTVAL INTO :NEW.Attendance_ID FROM DUAL;\n" +
            "END;\n" +
            "\n" +
            "select * from table(dbms_xplan.display_cursor(sql_id=>'null', format=>'ALLSTATS LAST'));\n" +
            "\n";
}
