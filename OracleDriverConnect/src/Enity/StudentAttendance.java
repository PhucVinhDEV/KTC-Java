package Enity;

public class StudentAttendance {
    private int stavId;
    private int StudentID;
    private int attendance;
    private Boolean status;

    public StudentAttendance(int stavId, int StudentID, int attendance, Boolean status) {
        this.stavId = stavId;
        this.StudentID = StudentID;
        this.attendance = attendance;
        this.status = status;
    }

    public StudentAttendance() {
    }

    public int getStavId() {
        return stavId;
    }

    public void setStavId(int stavId) {
        this.stavId = stavId;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentAttendance{" +
                "stavId=" + stavId +
                ", name='" + StudentID + '\'' +
                ", attendance=" + attendance +
                ", status='" + status + '\'' +
                '}';
    }
}
