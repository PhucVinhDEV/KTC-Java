package Enity;

import java.util.Date;

public class Attendance {
    private int attendanceId;
    private Date attendanceDate;
    private String username;

    // Constructors
    public Attendance() {
    }

    public Attendance(int attendanceId, Date attendanceDate, int stavId, String username) {
        this.attendanceId = attendanceId;
        this.attendanceDate = attendanceDate;

        this.username = username;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // toString method (optional for debugging)
    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", attendanceDate=" + attendanceDate +
                ", username='" + username + '\'' +
                '}';
    }
}
