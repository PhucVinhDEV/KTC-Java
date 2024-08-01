package Utils;

import Dao.StaffDAO;
import Implement.StudentAttendanceImpl;
import Service.StudentAttendanceService;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    StudentAttendanceService service = new StudentAttendanceImpl();

    Scanner sc = new Scanner(System.in);
    StaffDAO dao = new StaffDAO();

    public void MainMenu(){
        System.out.println("Login ne");
        System.out.print("User Name: ");
        String userName = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        dao.login(userName,password);
        if (Auth.isLogin()){
            System.out.println("Chức năng:");
            System.out.println("1. Action Attendance");
            System.out.println("2. View Attendance");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    service.Attendance();
                    break;
                case 2:
                    System.out.println("Input Date Attendance (dd-MMM-yy): ");
                    String dateString = sc.next(); // Read the input date
                    sc.nextLine();
                    // Debug print to verify the date string
                    System.out.println("Check: " + dateString);
                    service.ViewAttendanceByDate(dateString);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

}
