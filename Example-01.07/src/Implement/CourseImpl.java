package Implement;

import Model.Course;
import Model.Student;
import Service.CoureService;

import java.sql.SQLOutput;

public class CourseImpl implements CoureService {

    @Override
    public void displayDetaiCourse(Course course) {
        if(course != null) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Mentor Name" + course.getMentorName());
            System.out.println("Credit" + course.getCredit());
            System.out.println("Course ID" + course.getCourseId());
        }else {
            System.out.println("Course is null");
        }
    }
}
