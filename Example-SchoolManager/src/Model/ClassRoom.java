package Model;

import Util.FinalMaxNumber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private int classRoomID;
    private String classRoomName;
    private List<Student> students;
    private LocalDate startDate;

    public ClassRoom(int classRoomID, String classRoomName) {
        this.classRoomID = classRoomID;
        this.classRoomName = classRoomName;
        this.students = new ArrayList<>();
    }

    // Getter and Setter methods

    public boolean addStudent(Student student) {
        if (students.size() < FinalMaxNumber.MAX_STUDENT_INCLASSROOM_NUMBER) {
            students.add(student);
            if (students.size() == FinalMaxNumber.MAX_STUDENT_INCLASSROOM_NUMBER) {
                this.startDate = LocalDate.now();
                setRegistrationDateForStudents();
            }
            return true;
        } else {
            System.out.println("Classroom is full.");
            return false;
        }
    }

    private void setRegistrationDateForStudents() {
        for (Student student : students) {
            student.setRegistrationDate(this.startDate);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(int classRoomID) {
        this.classRoomID = classRoomID;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomID=" + classRoomID +
                ", classRoomName='" + classRoomName + '\'' +
                ", students=" + students +
                ", startDate=" + startDate +
                '}';
    }
}
