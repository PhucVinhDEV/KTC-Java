import Implement.CompanyImpl;
import Implement.DepartmentImpl;
import Implement.EmployeeImpl;
import Model.Company;
import Model.Department;
import Sevice.CompanyService;
import Sevice.DepartmentService;
import Sevice.EmplyeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Company company = new Company();
    CompanyService companyService = new CompanyImpl();
    DepartmentService departmentService = new DepartmentImpl();
    EmplyeeService emplyeeService = new EmployeeImpl();

    public void Menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, hãy nhập tên công ty của bạn:");
        String companyName = sc.nextLine();
        company.setName(companyName);

        companyService.inputDataStart(company);
        do {
            System.out.println("\t\t Menu Tìm kiếm:");
            System.out.println("1. In ra danh sách công ty");
            System.out.println("2. Quản Lý phòng ban");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            while (choice < 1 || choice > 4) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }

            switch (choice) {
                case 1:
                    companyService.prinfData(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 2:
                    MenuDepartment();
                    break;
                case 3:
                    MenuEmployee();
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    break;
            }
        } while (choice != 4);
    }
    public void MenuDepartment(){
        int chon;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\t\t Menu Quản lý phòng ban:");
            System.out.println("1. Thêm phòng ban");
            System.out.println("2. Sửa phòng ban");
            System.out.println("3. Xóa phòng ban");
            System.out.println("4. Chi tiết phòng ban");
            System.out.println("5. Trở lại");
            System.out.println("Mời bạn chọn chức năng:");
            chon = sc.nextInt();
            while (chon < 1 || chon > 5) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                chon = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }
            switch(chon) {
                case 1:
                    departmentService.insert(company);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 2:
                    departmentService.update(company);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 3:
                    departmentService.delete(company);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 4:
                    departmentService.prinfDetailDepartment(company);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 5:
                    return; // Trở về Menu chín
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (chon != 0);
    }
    public void MenuEmployee() {
        int chon;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\t\t Menu Quản lý phòng ban:");
            System.out.println("1. Thêm phòng nhân viên");
            System.out.println("2. Sửa phòng nhân viên");
            System.out.println("3. Xóa phòng nhân viên");
            System.out.println("4. Chi tiết phòng nhân viên");
            System.out.println("5. Nhân viên chưa có phòng ban");
            System.out.println("6. Trở lại");
            System.out.print("Mời bạn chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            while (chon < 1 || chon > 6) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                chon = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }

            switch (chon) {
                case 1:
                    emplyeeService.insert(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 2:
                    emplyeeService.update(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 3:
                    emplyeeService.delete(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 4:
                    emplyeeService.prinfDetailEmployee(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 5:
                    emplyeeService.prinfEmployeeDefault(company);
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 6:
                    return; // Trở về Menu chính
            }
        } while (chon != 6);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.Menu();

    }
}