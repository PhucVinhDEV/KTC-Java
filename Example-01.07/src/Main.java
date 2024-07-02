import Implement.CourseImpl;
import Model.Course;
import Model.CourseOnline;
import Model.Student;
import Service.CoureService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create a list to hold Course objects
        List<Course> courses = new ArrayList<>();

        // Create some Student objects
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");

        // Create a list of students
        List<Student> students = Arrays.asList(student1, student2);

        // Create a CourseOnline object
        CourseOnline courseOnline = new CourseOnline(
                101,                    // courseId
                "Java Programming",     // courseName
                "Dr. Smith",            // mentorName
                3,                      // credit
                "Zoom",                 // nenTang
                40                      // thoiLuong
        );


        // Create a regular Course object
        Course regularCourse = new Course(
                102,                    // courseId
                "Data Structures",      // courseName
                "Dr. Johnson",          // mentorName
                4                       // credit
        );

        // Set the students for the regular Course object
        regularCourse.setStudents(students);

        // Add the regular Course object to the list
        courses.add(regularCourse);

        // Set the students for the CourseOnline object
        courseOnline.setStudents(students);

        // Add the CourseOnline object to the list
        courses.add(courseOnline);

        CoureService coureService = new CourseImpl();

        System.out.println("Course Online:");
        coureService.displayDetaiCourse(courseOnline);
        System.out.println("Course :");
        coureService.displayDetaiCourse(regularCourse);

        System.out.println("Student Online:");
        CoureService.displayStudentOfCourse(courseOnline);

        System.out.println("Student Course Basic::");
        CoureService.displayStudentOfCourse(regularCourse);

    }
}