package Implement;

import Model.Company;
import Model.Department;
import Model.Employee;
import Sevice.CompanyService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CompanyImpl implements CompanyService {
    @Override
    public void inputDataStart(Company company) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập phòng ban:");


        Employee employee = new Employee();
        List<Department> listDepartment = new ArrayList<>();


        int i =0;
        do {
            List<Employee> listEmployeeOfDepartment = new ArrayList<>();
            Department department = new Department();
            System.out.printf("Tên phòng ban thứ %d: ", i + 1);
            String departmentname = sc.nextLine();
            if (departmentname == null || departmentname.equals("")) {
                break;
            }
            String departmentID;
            System.out.printf("Mã phòng ban thứ %d: ",i + 1);
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
                    addEmployee(company,employee);
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
            i++;
        }while (true);
        System.out.println(company.getListDepartments());
    }

    @Override
    public void prinfData(Company company) {
        int employeeCount = (company.getListEmployees() == null) ? 0 : company.getListEmployees().size();

        System.out.println("Tên Công ty: " + company.getName());
        System.out.println("Số phòng ban: " + company.getListDepartments().size());
        System.out.println("Số nhân viên: " + employeeCount);

        // table format

        /*
        %: Đánh dấu bắt đầu của định dạng chuỗi.
        -: Canh lề trái (left-justify) cho chuỗi.
        5: Chiều rộng tối thiểu của chuỗi (5 ký tự).
        s: Chuỗi đầu vào sẽ được định dạng theo định dạng này.
         */
        System.out.printf("%-5s %-20s %-10s\n", "ID", "Tên Phòng Ban", "Số Nhân Viên");
        for (Department d : company.getListDepartments()) {
            int deptEmployeeCount = (d.getListEmployee() == null) ? 0 : d.getListEmployee().size();
            System.out.printf("%-5s %-20s %-10d\n", d.getId(), d.getName(), deptEmployeeCount);
        }
    }

    @Override
    public void addEmployee(Company company, Employee employee) {
        List<Employee> listEmp = company.getListEmployees();

        if(listEmp == null){
            List<Employee> newlist = new ArrayList<>();
            newlist.add(employee);
            company.setListEmployees(newlist);
        }else {
            listEmp.add(employee);
            company.setListEmployees(listEmp);
        }
    }
}
