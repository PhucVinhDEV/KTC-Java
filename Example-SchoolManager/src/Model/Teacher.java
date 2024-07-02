package Model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherID;
    private String name;
    private List<ClassRoom> assignedClassrooms;

    public Teacher(int teacherID, String name, List<ClassRoom> assignedClassrooms) {
        this.teacherID = teacherID;
        this.name = name;
        this.assignedClassrooms = assignedClassrooms;
    }

    // Getter and Setter methods

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (ClassRoom classroom : assignedClassrooms) {
            allStudents.addAll(classroom.getStudents());
        }
        return allStudents;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", name='" + name + '\'' +
                ", assignedClassrooms=" + assignedClassrooms +
                '}';
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassRoom> getAssignedClassrooms() {
        return assignedClassrooms;
    }

    public void setAssignedClassrooms(List<ClassRoom> assignedClassrooms) {
        this.assignedClassrooms = assignedClassrooms;
    }
}
