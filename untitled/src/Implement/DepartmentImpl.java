package Implement;

import Model.Company;
import Model.Department;
import Model.Employee;
import Sevice.CompanyService;
import Sevice.DepartmentService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DepartmentImpl implements DepartmentService {
    private CompanyService companyService = new CompanyImpl();


    @Override
    public void insert(Company company) {
        List<Department> listDepartment = company.getListDepartments();
       if(listDepartment.size()>=5){
           System.out.println("Số phòng ban đã la tối đa không thể thêm");
       }else {
           Scanner sc = new Scanner(System.in);
           Employee employee = new Employee();
           List<Employee> listEmployeeOfDepartment = new ArrayList<>();
           System.out.println("Thêm Phòng Ban");
           Department department = new Department();
           System.out.println("Tên phòng ban thứ : ");
           String departmentname = sc.nextLine();
           String departmentID;
           System.out.println("Mã phòng ban thứ %d: ");
           departmentID = sc.nextLine();
           // Consume the newline character
           boolean isDuplicate;
           System.out.println("Thêm Nhân viên cho phòng ban: ");
           System.out.println("        1. Có");
           System.out.println("        2. Để sau");
           System.out.print("Mời chọn: ");
           int y = sc.nextInt();
           sc.nextLine();

           if (y==1){

               int exit;
               System.out.println("Nhập NV");
               do {
                   System.out.println("Nhập Mã NV:");
                   String employeeId = sc.nextLine();

                   System.out.println("Nhập tên NV:");
                   String employeeName = sc.nextLine();

                   System.out.println("Nhập tuổi NV:");
                   int age = sc.nextInt();

                   employee.setId(employeeId);
                   employee.setAge(age);
                   employee.setName(employeeName);
                   employee.setDepartment(department);
                   employee.setJoinDate(new Date());

                   listEmployeeOfDepartment.add(employee);
                   companyService.addEmployee(company,employee);
                   System.out.println("Bạn tiếp tục?");
                   System.out.println("0.Kêt Thúc");
                   System.out.println("1.Tiếp Tục");
                   exit = sc.nextInt();
                   sc.nextLine();

               }while (exit == 1);
               department.setId(departmentID);
               department.setName(departmentname);
               department.setListEmployee(listEmployeeOfDepartment);
               System.out.println("test department"+department.getName());
               listDepartment.add(department);
           } else if (y ==2) {

               System.out.println("Để sau");
               department.setId(departmentID);
               department.setName(departmentname);
               System.out.println("test department"+department.getName());
               listDepartment.add(department);
           }
           company.setListDepartments(listDepartment);
       }
    }

    @Override
    public void update(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách phòng ban");
        // Hiển thị danh sách các phòng ban
        for (int i = 0; i < company.getListDepartments().size(); i++) {
            Department dept = company.getListDepartments().get(i);
            int size = (dept.getListEmployee() == null) ? 0 : dept.getListEmployee().size();
            System.out.println("Phòng Ban " + (i + 1) + ": " + dept.getName() + " - Số lượng nhân viên: " + size);
        }

        // Yêu cầu người dùng chọn phòng ban muốn cập nhật
        System.out.println("Bạn muốn Cập nhật phòng ban nào? Vui lòng nhập đúng số thứ tự phòng ban:");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Kiểm tra lựa chọn hợp lệ
        if (choice < 1 || choice > company.getListDepartments().size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }


        Department selectedDept = company.getListDepartments().get(choice - 1);

        // Yêu cầu người dùng nhập tên mới cho phòng ban
        System.out.println("Nhập tên mới cho phòng ban:");
        String departmentName = sc.nextLine();
        selectedDept.setName(departmentName);
        System.out.println("Tên phòng ban đã được cập nhật.");

        // Hỏi người dùng có muốn cập nhật nhân viên trong phòng ban hay không
        System.out.println("Bạn có muốn cập nhật nhân viên trong phòng ban này không? (yes/no)");
        String updateEmployees = sc.nextLine();

        if (updateEmployees.equalsIgnoreCase("yes")) {
            // Hiển thị danh sách nhân viên
            for (int i = 0; i < selectedDept.getListEmployee().size(); i++) {
                Employee emp = selectedDept.getListEmployee().get(i);
                System.out.println("Nhân viên " + (i + 1) + ": " + emp.getName() + ", Tuổi: " + emp.getAge());
            }

            System.out.println("Bạn muốn cập nhật nhân viên nào? Vui lòng nhập đúng số thứ tự nhân viên:");
            int empChoice = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Kiểm tra lựa chọn hợp lệ
            if (empChoice < 1 || empChoice > selectedDept.getListEmployee().size()) {
                System.out.println("Lựa chọn không hợp lệ.");
                return;
            }

            Employee selectedEmp = selectedDept.getListEmployee().get(empChoice - 1);

            // Yêu cầu người dùng nhập thông tin mới cho nhân viên
            System.out.println("Nhập tên mới cho nhân viên:");
            String employeeName = sc.nextLine();
            System.out.println("Nhập tuổi mới cho nhân viên:");
            int employeeAge = sc.nextInt();
            sc.nextLine(); // Consume newline

            selectedEmp.setName(employeeName);
            selectedEmp.setAge(employeeAge);
            System.out.println("Thông tin nhân viên đã được cập nhật.");
        }
    }

    @Override
    public void delete(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách phòng ban");
        int size =0 ;
        for (int i = 0 ; i < company.getListDepartments().size();i++){

            if(company.getListDepartments().get(i).getListEmployee()==null){
                size=0;
            }else{
                size=company.getListDepartments().get(i).getListEmployee().size();
            }
            System.out.println("Phòng Ban:  "+ i + "   |"+ company.getListDepartments().get(i).getName() + " |  Số lượng nhân viên :" + size);        }
        if( company.getListDepartments().size()==1){
            System.out.println("Chỉ còn 1 phòng ban bạn ko thể xóa ?");
        }else {
            System.out.println("Bạn muốn xoa phòng ban nào ?. Vui lòng nhập đúng số thứ tự phòng ban");
            int choice = sc.nextInt();

            Department department = company.getListDepartments().get(choice);
            if (department.getListEmployee()==null){
                company.getListDepartments().remove(department);
                System.out.println("Đã xóa " + department.getName());
            }else{
                for(Employee e : company.getListEmployees()){
                    e.setDepartment(null);
                }
                company.getListDepartments().remove(department);
                System.out.println("Đã xóa " + department.getName());
            }
        }
    }

    @Override
    public void prinfDetailDepartment(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách phòng ban");
        int size =0 ;
        for (int i = 0 ; i < company.getListDepartments().size();i++){

            if(company.getListDepartments().get(i).getListEmployee()==null){
                size=0;
            }else{
                size=company.getListDepartments().get(i).getListEmployee().size();
            }
            System.out.println("Phòng Ban:  "+ i + "   |"+ company.getListDepartments().get(i).getName() + " |  Số lượng nhân viên :" + size);
        }
        System.out.println("Bạn muốn xem phòng ban nào ?. Vui lòng nhập đúng số thứ tự phòng ban");
        int choice = sc.nextInt();
        prinDepartment(company.getListDepartments().get(choice));

    }

    public void prinDepartment(Department department) {
        System.out.println("Tên phòng ban: " + department.getName());
        System.out.println("Mã phòng ban: " + department.getId());
        System.out.println("Danh sách Nhân viên:");

        if (department.getListEmployee() == null || department.getListEmployee().isEmpty()) {
            System.out.println("Phòng ban không có nhân viên!");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            for (Employee e : department.getListEmployee()) {
                String joinDate = sdf.format(e.getJoinDate());
                System.out.printf("Tên: %-10s | Mã Nhân Viên: %-10s | Tuổi: %-3d | Ngày gia nhập: %-12s \n",
                        e.getName(), e.getId(), e.getAge(), joinDate);
            }
        }
    }
}
