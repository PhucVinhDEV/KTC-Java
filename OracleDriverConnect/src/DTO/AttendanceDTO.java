package DTO;

public class AttendanceDTO {
    private String name;
    private String userAttendance;
    private boolean status;

    public AttendanceDTO(String name, String userAttendance, boolean status) {
        this.name = name;

        this.userAttendance = userAttendance;
        this.status = status;
    }

    public AttendanceDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUserAttendance() {
        return userAttendance;
    }

    public void setUserAttendance(String userAttendance) {
        this.userAttendance = userAttendance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
