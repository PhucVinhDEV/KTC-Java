package Implement;

import Model.ClassRoom;
import Model.Student;
import Model.Teacher;
import Service.ClassroomService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassRoomImpl implements ClassroomService {


    @Override
    public boolean registerStudent(ClassRoom classroom, Student student) {
        if (student.isEligible()) {
            return classroom.addStudent(student);
        } else {
            System.out.println("Student is not eligible to register (Age must be between 18 and 20).");
            return false;
        }
    }

    @Override
    public boolean updateStudent(ClassRoom classroom, int studentID, String newName, String newDob, String newCccd) {
        for (Student student : classroom.getStudents()) {
            if (student.getStudentID() == studentID) {
                student.setName(newName);
                student.setDateOfBirth(LocalDate.parse(newDob, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                student.setCccd(newCccd);
                System.out.println("Student information updated.");
                return true;
            }
        }
        System.out.println("Student not found.");
        return false;
    }

    @Override
    public boolean dropStudent(ClassRoom classroom, int studentID, String reason) {
        for (Student student : classroom.getStudents()) {
            if (student.getStudentID() == studentID) {
                student.setDropped(true);
                student.setDropReason(reason);
                System.out.println("Student has dropped out: " + reason);
                return true;
            }
        }
        System.out.println("Student not found.");
        return false;
    }

    @Override
    public void showClassroomStudents(ClassRoom classroom) {
        System.out.println("Classroom " + classroom.getClassRoomName() + " students:");

        for (Student student : classroom.getStudents().stream().sorted(Comparator.comparing(Student::getStudentID)).toList()) {
            if (!student.isDropped()) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void showStudentsDrop(ClassRoom classroom) {
        System.out.println("Classroom " + classroom.getClassRoomName() + " students drop:");
        for (Student student : classroom.getStudents()) {
            if (student.isDropped()) {
                System.out.println(student);
            }
        }
    }


    @Override
    public void showTeacherStudents(Teacher teacher) {
        System.out.println("Teacher " + teacher.getName() + " students:");
        for (Student student : teacher.getAllStudents().stream().sorted(Comparator.comparing(Student::getStudentID)).toList()) {
            if (!student.isDropped()) {
                System.out.println(student);
            }
        }
    }
}
