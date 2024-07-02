package Service;

import Model.ClassRoom;
import Model.Student;
import Model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface ClassroomService {
       boolean registerStudent(ClassRoom classroom, Student student);
       boolean updateStudent(ClassRoom classroom, int studentID, String newName, String newDob, String newCccd);
       boolean dropStudent(ClassRoom classroom, int studentID, String reason);
       void showClassroomStudents(ClassRoom classroom);
       void showStudentsDrop(ClassRoom classroom);
       void showTeacherStudents(Teacher teacher);

}
