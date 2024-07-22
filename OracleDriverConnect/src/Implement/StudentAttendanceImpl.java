package Implement;

import DTO.AttendanceDTO;
import Dao.AttendanceDAO;
import Dao.StudentAttendanceDAO;
import Dao.StudentDAO;
import Enity.Attendance;
import Enity.Student;
import Enity.StudentAttendance;
import Service.StudentAttendanceService;
import Utils.Auth;

import java.util.*;


public class StudentAttendanceImpl implements StudentAttendanceService {
    private static final Random random = new Random();

    public static int generateRandomId() {
        // Tạo một ID ngẫu nhiên trong khoảng từ 1 đến 10000 (bạn có thể thay đổi phạm vi này nếu cần)
        return random.nextInt(10000) + 1;
    }

    Scanner sc = new Scanner(System.in);
    StudentDAO studentDAO = new StudentDAO();
    AttendanceDAO attendanceDAO = new AttendanceDAO();
    StudentAttendanceDAO studentAttendanceDAO = new StudentAttendanceDAO();

    @Override
    public void Attendance() {
        if (Auth.isLogin() && Auth.getPermissions().contains("Advandance")){
            List<Student> list = studentDAO.getAllStudents();
            List<StudentAttendance> listStat = new ArrayList<>();

            Attendance att = new Attendance();
            att.setAttendanceId(generateRandomId());
            att.setAttendanceDate( new Date());
            att.setUsername(Auth.getUser().getUsername());
            attendanceDAO.insertAttendance(att);
            for (Student st: list){
                System.out.print("ID "+ st.getStId());
                System.out.print("Name"+ st.getName());
                System.out.print("Status (true / false) : ");
                Boolean sttinput = sc.nextBoolean();
                StudentAttendance stav = new StudentAttendance();
                stav.setAttendance(att.getAttendanceId());
                stav.setStatus(sttinput);
                stav.setStudentID(st.getStId());
                listStat.add(stav);
            }
                for(StudentAttendance stat : listStat){
                    studentAttendanceDAO.insertStudentAttendance(stat);
                }
            System.out.println("Attendance Succesfully !");
        }else {
            System.out.println("Unauthorized");
        }
    }

    @Override
    public void ViewAttendanceByDate(String date) {
     if(Auth.isLogin() && Auth.getPermissions().contains("view")){
         List<AttendanceDTO> attendances = studentAttendanceDAO.selectByDate(date);
         System.out.println("Thong ke Diem Danh Ngay " + date);
         // Print header
         System.out.printf("%-20s %-10s %-20s%n", "Student Name", "Status", "User Attendance");
         System.out.println("---------------------------------------------");

         // Print data
         for (AttendanceDTO attendance : attendances) {
             System.out.printf("%-20s %-10b %-20s%n",
                     attendance.getName(),
                     attendance.isStatus(),
                     attendance.getUserAttendance());
         }
     }else {
         System.out.println("Unauthorized");
     }
    }
}
