package Model;

import java.util.List;

public class Course {
    final int courseId;
    private String courseName;
    private String mentorName;
    private int credit;
    private List<Student> students;
    public Course(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
    }
}
