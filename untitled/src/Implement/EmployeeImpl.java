package Implement;

import Model.Company;
import Model.Department;
import Model.Employee;
import Sevice.CompanyService;
import Sevice.EmplyeeService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeImpl implements EmplyeeService {
    @Override
    public void insert(Company company) {
        CompanyService companyService = new CompanyImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Danh sách phòng ban");
        for (int i = 0; i < company.getListDepartments().size(); i++) {
            Department department = company.getListDepartments().get(i);
            int size = (department.getListEmployee() == null) ? 0 : department.getListEmployee().size();
            System.out.printf("Phòng Ban: %d %s  Số lượng nhân viên: %d\n", i, department.getName(), size);
        }

        System.out.println("Bạn muốn thêm nhân viên vào phòng ban nào? Vui lòng nhập đúng số thứ tự phòng ban:");
        int choice = sc.nextInt();
        sc.nextLine();
        Department department = company.getListDepartments().get(choice);

        // Nếu phòng ban = null tạo list trống
        if (department.getListEmployee() == null) {
            department.setListEmployee(new ArrayList<>());
        }

        //Check số lượng NV trong phòng ban
        if (department.getListEmployee().size() < 3) {
            int exit;
            do {
                Employee employee = new Employee();

                System.out.println("Nhập Mã NV:");
                String employeeId = sc.nextLine();
                sc.nextLine();

                System.out.println("Nhập tên NV:");
                String employeeName = sc.nextLine();

                System.out.println("Nhập tuổi NV:");
                int age = sc.nextInt();
                sc.nextLine();

                employee.setId(employeeId);
                employee.setAge(age);
                employee.setName(employeeName);
                employee.setDepartment(department);
                employee.setJoinDate(new Date());

                department.getListEmployee().add(employee);
                companyService.addEmployee(company, employee);

                System.out.println("Bạn tiếp tục?");
                System.out.println("0. Kết Thúc");
                System.out.println("1. Tiếp Tục");
                exit = sc.nextInt();
                sc.nextLine();

            } while (exit == 1);

        } else {
            System.out.println("Phòng ban đã đủ nhân viên.");
        }
    }

    @Override
    public void update(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần tìm:");
        String maNV = sc.nextLine();
        boolean flag = false; // Đặt cờ để thoát khỏi điều kiện or  vòng lặp

        // Vòng lập để tìm nhân viên theo Mã NV
        for (Department d : company.getListDepartments()) {
            for (Employee e : d.getListEmployee()) {
                if (e.getId().equals(maNV)) {
                    flag = true;
                    System.out.println("Nhập tên nhân viên mới:");
                    String newName = sc.nextLine();

                    System.out.println("Nhập tuổi mới:");
                    int newAge = sc.nextInt();
                    sc.nextLine(); // Consume newline left-over

                    // Ask if user wants to update department
                    System.out.println("Bạn có muốn cập nhật phòng ban không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 1) {
                        System.out.println("Danh sách phòng ban:");
                        //Duyệt list in ra danh sách Department
                        for (int i = 0; i < company.getListDepartments().size(); i++) {
                            Department dept = company.getListDepartments().get(i);
                            int size = (dept.getListEmployee() == null) ? 0 : dept.getListEmployee().size();
                            System.out.printf("%d. %s | Số lượng nhân viên: %d\n", i, dept.getName(), size);
                        }
                        System.out.println("Bạn muốn chuyển nhân viên đến phòng ban nào? Nhập số thứ tự phòng ban:");
                        int index = sc.nextInt();
                        sc.nextLine();

                        //setDepartment in Employee
                        if (index >= 0 && index < company.getListDepartments().size()) {
                            e.setDepartment(company.getListDepartments().get(index));
                        } else {
                            System.out.println("Số thứ tự không hợp lệ. Không thay đổi phòng ban.");
                        }
                    }

                    // cập nhât employee's name and age
                    e.setName(newName);
                    e.setAge(newAge);

                    System.out.println("Thông tin nhân viên đã được cập nhật thành công.");
                    return;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy nhân viên với mã " + maNV);
        }
    }

    @Override
    public void delete(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần xóa:");
        String maNV = sc.nextLine();
        boolean flag = false;


        for (Department d : company.getListDepartments()) {
            for (Employee e : d.getListEmployee()) {
                if (e.getId().equals(maNV)) {
                    flag = true;
                    d.removeEmployee(maNV);
                    System.out.println("Nhân viên có mã " + maNV + " đã được xóa thành công.");
                    return;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy nhân viên có mã " + maNV);
        }
    }

    @Override
    public void prinfDetailEmployee(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần xóa !");
        String maNV = sc.nextLine();
        for (Department d:company.getListDepartments()){
            for (Employee e : d.getListEmployee()){
                if(e.getId().equals(maNV)){
                    System.out.printf(" Tên:%10s | Mã Nhân Viên:%10s | Tuổi:%10s | Ngày gia nhập:%10s | Tên phòng ban:%10s",e.getName(),e.getId() ,e.getAge() ,e.getJoinDate() , e.getDepartment().getName());
                }else {
                    System.out.println("Ko tìm thấy nhân viên !");
                }
            }
        }
    }

    @Override
    public void prinfEmployeeDefault(Company company) {
        for (Department d : company.getListDepartments()) {
            if (d.getListEmployee() != null && !d.getListEmployee().isEmpty()) {
                for (Employee e : d.getListEmployee()) {
                    if (e.getDepartment() == null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String joinDate = sdf.format(e.getJoinDate());
                        System.out.printf("Tên: %-10s | Mã Nhân Viên: %-10s | Tuổi: %-3d | Ngày gia nhập: %-10s\n",
                                e.getName(), e.getId(), e.getAge(), joinDate);
                    }
                }
            }
        }
    }
}
