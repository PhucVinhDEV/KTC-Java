

import Dao.StaffDAO;
import Dao.StudentDAO;
import Enity.Staff;
import Helper.FileWriteReader;
import Helper.JDBCHelper;
import Utils.Auth;
import Utils.Menu;

import java.sql.SQLException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {

//        Scanner sc = new Scanner(System.in);
//       List<String> listStudentName = FileWriteReader.readerFile("New");
//        StudentDAO studentDAO = new StudentDAO();
//       for(String studentName : listStudentName) {
//           studentDAO.insertStudent(studentName);
//       }

//        Staff Techer1 = new Staff("tuan1102", Base64.getEncoder().encodeToString(("123123").getBytes()),"Tuấn");
//        Staff Techer2 = new Staff("techer2", Base64.getEncoder().encodeToString(("123123").getBytes()),"Vinh2");
//        Staff Mentor1 = new Staff("duong1102", Base64.getEncoder().encodeToString(("123123").getBytes()),"Dương");
//        Staff Mentor2 = new Staff("mentor2", Base64.getEncoder().encodeToString(("123123").getBytes()),"Vinh3");
//        List<Staff> listStaff = new ArrayList<>(Arrays.asList(Techer1,Techer2,Mentor1,Mentor2));
//        StaffDAO dao = new StaffDAO();
//
//        for(Staff st : listStaff){
//            dao.insertStaff(st);
//        }
        Menu menu = new Menu();
        menu.MainMenu();

        String wew = new String();
        wew.length()
    }
}