package Bai2;

public class HrManager extends NhanVien{

    @Override
    public void work(){
        System.out.println("Working as a Employee");
    }

    @Override
    public void getsalary(){
        System.out.println("Salary is "+ 70000);
    }

    public void addEmployee(){
        System.out.println("Add new a Employee");
    }
}
