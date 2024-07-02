import Implement.ClassRoomImpl;
import Model.ClassRoom;
import Model.Student;
import Model.Teacher;
import Service.ClassroomService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ClassroomService classroomService = new ClassRoomImpl();
    static Scanner scanner = new Scanner(System.in);
    // Create classrooms
    private static final ClassRoom class1 = new ClassRoom(1, "Classroom 1");
    private static final ClassRoom class2 = new ClassRoom(2, "Classroom 2");
    private static final ClassRoom class3 = new ClassRoom(3, "Classroom 3");

    // Assign teachers to classrooms
    private static final List<ClassRoom> teacher1Classes = List.of(class1, class2);
    private static final List<ClassRoom> teacher2Classes = List.of(class2, class3);
    private static final List<ClassRoom> teacher3Classes = List.of(class1, class3);

    private static final Teacher teacher1 = new Teacher(1, "Mr. Smith", teacher1Classes);
    private static final Teacher teacher2 = new Teacher(2, "Ms. Johnson", teacher2Classes);
    private static final Teacher teacher3 = new Teacher(3, "Mrs. Brown", teacher3Classes);



    public static void main(String[] args) {


        // Register students
        classroomService.registerStudent(class1, new Student("Alice", "15/07/2003", "123456789"));
        classroomService.registerStudent(class1, new Student("Bob", "20/09/2003", "987654321"));
        classroomService.registerStudent(class2, new Student("Charlie", "05/12/2003", "456123789"));
        classroomService.registerStudent(class2, new Student("David", "25/02/2004", "789321456"));
        classroomService.registerStudent(class3, new Student("Eve", "30/01/2004", "321654987"));
        classroomService.registerStudent(class3, new Student("Frank", "12/11/2003", "654987321"));

        // Thêm nhiều học sinh
        classroomService.registerStudent(class1, new Student("George", "02/03/2004", "147258369"));
        classroomService.registerStudent(class1, new Student("Hannah", "19/04/2004", "963852741"));
        classroomService.registerStudent(class2, new Student("Ian", "22/05/2004", "852741963"));
        classroomService.registerStudent(class2, new Student("Jack", "18/06/2004", "741852963"));
        classroomService.registerStudent(class3, new Student("Karen", "09/07/2004", "369258147"));
        classroomService.registerStudent(class3, new Student("Leo", "15/08/2004", "258147369"));
        classroomService.registerStudent(class1, new Student("Michael", "21/09/2003", "123987456"));
        classroomService.registerStudent(class1, new Student("Nina", "28/10/2003", "987321654"));
        classroomService.registerStudent(class2, new Student("Oliver", "13/11/2003", "456789123"));
        classroomService.registerStudent(class2, new Student("Paul", "25/12/2003", "789123456"));
        classroomService.registerStudent(class3, new Student("Quincy", "08/01/2004", "321987654"));
        classroomService.registerStudent(class3, new Student("Rachel", "14/02/2004", "654321987"));
        classroomService.registerStudent(class1, new Student("Steve", "23/03/2004", "123654789"));
        classroomService.registerStudent(class1, new Student("Tina", "17/04/2004", "987654123"));
        classroomService.registerStudent(class2, new Student("Uma", "11/05/2004", "456123987"));
        classroomService.registerStudent(class2, new Student("Victor", "19/06/2004", "789456321"));
        classroomService.registerStudent(class3, new Student("Wendy", "27/07/2004", "321654123"));
        classroomService.registerStudent(class3, new Student("Xavier", "03/08/2004", "654123987"));







        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Show students in classrooms");
            System.out.println("2. Show students assigned to each teacher");
            System.out.println("3. Drop a student from a classroom");
            System.out.println("4. Update a student from a classroom");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (option) {
                case 1:
                    showStudentInClassrooms();
                    scanner.nextLine();
                    break;
                case 2:
                    showStudentsAssignedToTeachers();
                    scanner.nextLine();
                    break;
                case 3:
                    dropStudentFromClassroom();
                    scanner.nextLine();
                    break;
                case 4:
                    updateStudentFromClassroom();
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
    private static void showStudentInClassrooms() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Menu ===");
            System.out.println(" Show students in classrooms");
            System.out.println("1. Show all students in classrooms");
            System.out.println("2. Show students assigned to " + teacher1.getName());
            System.out.println("3. Show students assigned to " + teacher2.getName());
            System.out.println("4. Show students assigned to " + teacher3.getName());
            System.out.println("5. Return to main menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllStudentsInClassrooms();
                    break;
                case 2:
                    System.out.println("Teacher 1:");
                    classroomService.showTeacherStudents(teacher1);
                    break;
                case 3:
                    System.out.println("Teacher 2:");
                    classroomService.showTeacherStudents(teacher2);
                    break;
                case 4:
                    System.out.println("Teacher 3:");
                    classroomService.showTeacherStudents(teacher3);
                    break;
                case 5:
                   return;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void showAllStudentsInClassrooms() {
        System.out.println("=== Students in Classrooms ===");
        classroomService.showClassroomStudents(class1);
        classroomService.showClassroomStudents(class2);
        classroomService.showClassroomStudents(class3);
        System.out.println();
    }

    private static void showStudentsAssignedToTeachers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Show students assigned to " + teacher1.getName());
            System.out.println("2. Show students assigned to " + teacher2.getName());
            System.out.println("3. Show students assigned to " + teacher3.getName());
            System.out.println("4. Return to main menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Teacher 1:");
                    classroomService.showTeacherStudents(teacher1);
                    break;
                case 2:
                    System.out.println("Teacher 2:");
                    classroomService.showTeacherStudents(teacher2);
                    break;
                case 3:
                    System.out.println("Teacher 3:");
                    classroomService.showTeacherStudents(teacher3);
                    break;
                case 4:

                    return;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void dropStudentFromClassroom() {
        System.out.println("=== Drop a student from a classroom ===");
        System.out.print("Enter classroom ID: ");
        int classroomId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter student ID to drop: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter drop reason: ");
        String dropReason = scanner.nextLine();

        // Depending on your implementation, you may need to fetch the correct class object
        // instead of using predefined class1, class2, class3.
        ClassRoom classroom = getClassroomById(classroomId);
        if (classroom != null) {
            classroomService.dropStudent(classroom, studentId, dropReason);
            System.out.println("Student dropped successfully.");
            classroomService.showClassroomStudents(classroom);
            classroomService.showStudentsDrop(classroom);
        } else {
            System.out.println("Classroom not found.");
        }
        System.out.println();
    }
    private static void updateStudentFromClassroom(){

        System.out.println("=== Delete a student from a classroom ===");
        System.out.print("Enter classroom ID: ");
        int classroomId = scanner.nextInt();
        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter student new name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter student new date of birth (dd/MM/yyyy): ");
        String dateOfBirth;
        while (true) {
            dateOfBirth = scanner.nextLine();
            if (isValidDate(dateOfBirth)) {
                break;
            } else {
                System.out.print("Invalid date format. Please enter again (dd/MM/yyyy): ");
            }
        }

        System.out.print("Enter student new CCCD: ");
        String cccd = scanner.nextLine();
        ClassRoom classroom = getClassroomById(classroomId);
        if (classroom != null) {
            classroomService.updateStudent(classroom, studentId,newName,dateOfBirth,cccd);
            System.out.println("Student update successfully.");
            classroomService.showClassroomStudents(classroom);
        } else {
            System.out.println("Classroom not found.");
        }
        System.out.println();
    }
    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private static ClassRoom getClassroomById(int classroomId) {
        // Replace with your logic to retrieve the class object by ID
        switch (classroomId) {
            case 1:
                return class1;
            case 2:
                return class2;
            case 3:
                return class3;
            default:
                return null;
        }
    }
    }
