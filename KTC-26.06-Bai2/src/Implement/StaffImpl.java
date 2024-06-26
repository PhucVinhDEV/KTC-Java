package Implement;

import Model.Manager;
import Model.MarketingStaff;
import Model.Staff;
import Service.StaffService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StaffImpl implements StaffService {

    @Override
    public void printStaff(List<Staff> list)  {
        if (list.isEmpty()) {
            System.out.println("Empty List");
        }else {
            System.out.println("Danh Sách Nhân Viên là: ");
            for (Staff staff : list) {
                staff.output();
            }
        }

    }

    @Override
    public void print5Staff(List<Staff> list)  {
        if (list.isEmpty()) {
            System.out.println("Empty List");
        }else {
            System.out.println("Danh Sách Nhân Viên là: ");
            for ( int i = 0 ; i < 5 ; i++) {
                list.get(i).output();
            }
        }

    }

    @Override
    public void inputStaff(List<Staff> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập danh sách Nhân Viên:");
        int i = 0;
        do {
            System.out.printf("Tên Nhân Viên thứ %d: ", i + 1);
            String name = sc.nextLine();
            if (name == null || name.equals("")) {
                break;
            }
            String MaNV;
            boolean isDuplicate;
            do {
                isDuplicate = false;
                System.out.printf("Mã Nhân Viên thứ %d: ", i + 1);
                MaNV = sc.nextLine();
                for (Staff staff : list) {
                    if (staff.getID().equals(MaNV)) {
                        System.out.println("Mã Nhân Viên đã tồn tại. Vui lòng nhập mã khác.");
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            System.out.print("Lương Nhân Viên: ");
            BigDecimal wage = sc.nextBigDecimal();
            System.out.println("Chức vụ: 1. Trưởng Phòng");
            System.out.println("        2. Tiếp Thị");
            System.out.println("        3. Nhân Viên");
            System.out.print("Mời chọn: ");
            int y = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (y == 1) {
                System.out.println("Tiền Trách Nhiệm:");
                BigDecimal trachNhiem = sc.nextBigDecimal();
                sc.nextLine(); // Consume the newline character
                Staff nv = new Manager(MaNV, name, wage, trachNhiem);
                list.add(nv);
            } else if (y == 2) {
                System.out.println("Tiền Doanh Số:");
                BigDecimal sales = sc.nextBigDecimal();
                System.out.println("Tiền Hoa Hồng:");
                BigDecimal hoahong = sc.nextBigDecimal();
                sc.nextLine(); // Consume the newline character
                Staff nv = new MarketingStaff(MaNV, name, wage, sales);
                list.add(nv);
            } else if (y == 3) {
                Staff nv = new Staff(MaNV, name, wage);
                list.add(nv);
            }

            i++;
        } while (true);
    }



    @Override
    public void update(List<Staff> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Employee ID Delete:");
        String id = sc.nextLine();
        boolean flag = false;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getID().equals(id)) {
                System.out.printf("Tên Nhân Viên: ");
                String name = sc.nextLine();
                if (name == null || name.equals("")) {
                    break;
                }


                System.out.print("Lương Nhân Viên: ");
                BigDecimal wage = sc.nextBigDecimal();
                System.out.println("Chức vụ: 1. Trưởng Phòng");
                System.out.println("        2. Tiếp Thị");
                System.out.println("        3. Nhân Viên");
                System.out.print("Mời chọn: ");
                int y = sc.nextInt();
                sc.nextLine();

                if (y == 1) {
                    System.out.println("Tiền Trách Nhiệm:");
                    BigDecimal trachNhiem = sc.nextBigDecimal();
                    sc.nextLine();
                    Manager nv = new Manager(id, name, wage, trachNhiem);
                    list.set(i,nv);
                } else if (y == 2) {
                    System.out.println("Tiền Doanh Số:");
                    BigDecimal sales = sc.nextBigDecimal();
                    sc.nextLine();
                    MarketingStaff nv = new MarketingStaff(id, name, wage, sales);
                    list.set(i,nv);
                } else if (y == 3) {
                    Staff nv = new Staff(id, name, wage);
                    list.set(i,nv);
                }
            }
        }
    }

    @Override
    public void delete(List<Staff> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn tìm và xóa nhân viên theo:");
        System.out.println("1. Tên");
        System.out.println("2. Mã nhân viên");
        System.out.print("Mời chọn: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String searchCriteria;


        if (choice == 1) {
            System.out.println("Nhập họ và tên Nhân Viên cần tìm và xóa:");
            searchCriteria = sc.nextLine();
        } else if (choice == 2) {
            System.out.println("Nhập Mã Nhân Viên cần tìm và xóa:");
            searchCriteria = sc.nextLine();
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        int count = 0;
        for(Staff nv : list){
            if ((choice == 1 && nv.getName().equals(searchCriteria)) || (choice == 2 && nv.getID().equals(searchCriteria))) {
                list.remove(nv);
                System.out.println("Nhân Viên đã được xóa khỏi danh sách");
                count++;
                break;
            }
        }
        if(count ==0){
            System.out.println("Không tìm thấy Nhân viên cần tìm");
        }
    }

    @Override
    public void find(List<Staff> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn chức năng tìm kiếm :");
        System.out.println("1. Tìm kiếm theo họ tên");
        System.out.println("2. Tìm kiếm theo mã NV");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Nhập họ tên nhân viên cần tìm:");
                String name = sc.nextLine();
                for (Staff nv : list) {
                    if (nv.getName().equals(name)) {
                        nv.output();
                    }
                }
            case 2:
                System.out.println("Nhập Mã nhân viên :");
                String id = sc.nextLine();
                for (Staff nv : list) {
                    if (nv.getID().equals(id)) {
                        nv.output();
                    }
                }
        }
    }

    @Override
    public void SortByName(List<Staff> list) {
      list.stream()
                .sorted(Comparator.comparing(Staff::getName))
                .collect(Collectors.toList());
            }

    @Override
    public void SortByIncome(List<Staff> list) {
        list.stream().sorted(Comparator.comparing(Staff::ThuNhap)).collect(Collectors.toList());
    }

    @Override
    public void FindByRangeIncome(List<Staff> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập khoảng bắt đàu tìm :");
        String StartString = sc.nextLine();
        System.out.println("Nhập khoảng kết thúc tìm :");
        String EndString = sc.nextLine();

        BigDecimal start = new BigDecimal(StartString);
        BigDecimal end = new BigDecimal(EndString);

        for (Staff staff : list) {
            if (staff.ThuNhap().compareTo(start) >= 0 && staff.ThuNhap().compareTo(end) <= 0) {
                staff.output();
            }
        }
    }

}
