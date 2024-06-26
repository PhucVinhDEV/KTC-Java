import Implement.StaffImpl;
import Model.Staff;
import Service.StaffService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Staff> list = new ArrayList<Staff>();
    StaffService staffService = new StaffImpl();



    public void timthunhap(){
        System.out.println("Tìm các nhân viên theo khoảng lương nhập từ bàn phím.");
    }
    public void sxhoten(){
        System.out.println("Sắp xếp nhân viên theo họ và tên.");
    }
    public void sxthunhap(){
        System.out.println("Sắp xếp nhân viên theo thu nhập.");
    }
    public void xuat5(){
        System.out.println("Xuất 5 nhân viên có thu nhập cao nhất.");
    }
    public void MenuCRUD() {
        int chon;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\t\t Menu CRUD:");
            System.out.println("1. Nhập danh sách nhân viên từ bàn phím.");
            System.out.println("2. Xuất danh sách nhân viên ra màn hình.");
            System.out.println("3. Xóa nhân viên theo mã nhập từ bàn phím.");
            System.out.println("4. Cập nhật thông tin nhân viên theo mã nhập từ bàn phím.");
            System.out.println("5. Trở về Menu chính.");
            System.out.println("Mời bạn chọn chức năng:");
            chon = sc.nextInt();
            switch(chon) {
                case 1:
                    staffService.inputStaff(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 2:
                    staffService.printStaff(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 3:
                    staffService.delete(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 4:
                    staffService.update(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 5:
                    return; // Trở về Menu chính
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (chon != 0);
    }
    public void MenuSort() {
        int chon;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\t\t Menu Sắp xếp:");
            System.out.println("1. Sắp xếp nhân viên theo họ và tên.");
            System.out.println("2. Sắp xếp nhân viên theo thu nhập.");
            System.out.println("3. Xuất 5 nhân viên có thu nhập cao nhất.");
            System.out.println("4. Trở về Menu chính.");
            System.out.println("Mời bạn chọn chức năng:");
            chon = sc.nextInt();
            switch(chon) {
                case 1:
                    staffService.SortByName(list);
                    staffService.printStaff(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 2:
                    staffService.SortByIncome(list);
                    staffService.printStaff(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 3:
                    staffService.SortByIncome(list);
                    staffService.print5Staff(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 4:
                    return; // Trở về Menu chính
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (chon != 0);
    }
    public void MenuSearch() {
        int chon;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\t\t Menu Tìm kiếm:");
            System.out.println("1. Tìm và hiển thị nhân viên theo mã.");
            System.out.println("2. Tìm các nhân viên theo khoảng lương.");
            System.out.println("3. Trở về Menu chính.");
            System.out.println("Mời bạn chọn chức năng:");
            chon = sc.nextInt();
            switch(chon) {
                case 1:
                    staffService.find(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 2:
                    staffService.SortByIncome(list);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter để tiếp tục chương trình");
                    break;
                case 3:
                    return; // Trở về Menu chính
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (chon != 0);
    }
    public void Menu(){
        int chon;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\t\t Menu chính:");
            System.out.println("1. Quản lý nhân viên (CRUD).");
            System.out.println("2. Tìm kiếm nhân viên.");
            System.out.println("3. Sắp xếp nhân viên.");
            System.out.println("4. Thoát chương trình.");
            System.out.println("Mời bạn chọn chức năng:");
            chon = sc.nextInt();
            switch(chon) {
                case 1:
                    MenuCRUD();
                    break;
                case 2:
                    MenuSearch();
                    break;
                case 3:
                    MenuSort();
                    break;
                case 4:
                    System.out.println("Chào Tạm Biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (chon != 0);

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.Menu();
    }
}