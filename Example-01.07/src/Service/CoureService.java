package Service;

import Model.Course;
import Model.CourseOnline;
import Model.Student;

public interface CoureService {
    void displayDetaiCourse(Course course);

    static void displayStudentOfCourse(Course course){
            if(course.getStudents()!= null || !course.getStudents().isEmpty()) {
                for(Student student : course.getStudents()) {
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Student ID: " + student.getId());
                }
            }
    };

    default void displayDetaiCourse(CourseOnline course) {
        if (course != null) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Mentor Name" + course.getMentorName());
            System.out.println("Credit" + course.getCredit());
            System.out.println("Course ID" + course.getCourseId());
            System.out.println("Platform :" + course.getNenTang() + " has been displayed.");
            System.out.println(" Duration: " + course.getThoiLuong() + " has been displayed.");
        }else {
            System.out.println("Course is null");
        }
    }
    default void test(){
        System.out.println("123");
    }
}
