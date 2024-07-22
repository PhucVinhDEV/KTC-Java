package groupingBy_Entry;

import java.util.*;
import java.util.stream.Collectors;

public class MainUser {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25, "HR"),
                new User("Bob", 30, "Finance"),
                new User("Charlie", 28, "IT"),
                new User("David", 27, "HR"),
                new User("Eve", 26, "IT"),
                new User("Frank", 32, "Finance"),
                new User("Grace", 29, "HR"),
                new User("Henry", 31, "IT")
                // Thêm các đối tượng User khác nếu cần
        );

        // Phân loại và đếm số lượng nhân viên theo từng phòng ban
        Map<String, Long> departmentCounts = users.stream()
                .collect(Collectors.groupingBy(User::getDepartment, Collectors.counting()));


        // In ra số lượng nhân viên trong từng phòng ban
        System.out.println("Số lượng nhân viên theo từng phòng ban:");
        for (Map.Entry<String, Long> entry : departmentCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

//        Tạo một danh sách chứa tất cả các tên của người dùng.
        System.out.println(users.stream().map(User::getName).collect(Collectors.joining(",")).toString());


//        Tạo một tập hợp chứa tất cả các phòng ban (không trùng lặp).
        users.stream().map(User::getDepartment).distinct().forEach(System.out::println);

//        Tạo một bản đồ mà key là tên người dùng và value là tuổi của người dùng.
        Map<String,Integer> keyvalue = users.stream().collect(Collectors.toMap(User::getName,User::getAge));
        for (Map.Entry<String, Integer> entry : keyvalue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

//        Tính tổng số tuổi của tất cả người dùng.
        System.out.println(users.stream().mapToInt(User::getAge).sum());

//        Tính tuổi trung bình của người dùng.
        System.out.println(users.stream().mapToDouble(User::getAge).average());
//        Nhóm các người dùng theo phòng ban.
        Map<String, List<User>> usersByDepartment = users.stream()
                .collect(Collectors.groupingBy(User::getDepartment));

        for (Map.Entry<String, List<User>> entry : usersByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


//        Phân chia các người dùng thành hai nhóm: nhóm người dùng trên 30 tuổi và nhóm người dùng dưới hoặc bằng 30 tuổi.
        System.out.println("Nguoi dung tren 30");
            users.stream().filter(t -> t.getAge() > 30).forEach(System.out::println);
        System.out.println("Nguoi dung duuoi 30");
        users.stream().filter(t -> t.getAge() < 30).forEach(System.out::println);

//        Tìm người dùng có tuổi lớn nhất.
        // Tìm tuổi lớn nhất
        OptionalInt maxAge = users.stream()
                .mapToInt(User::getAge)
                .max();

        // In ra người dùng có tuổi lớn nhất nếu có
        int age = maxAge.getAsInt();
        System.out.println("Người dùng có tuổi lớn nhất:");
        users.stream()
                .filter(user -> user.getAge() == age)
                .forEach(System.out::println);
        //        Tạo một chuỗi chứa tên của tất cả người dùng, ngăn cách bằng dấu phẩy.

        users.stream().map(User::getName).collect(Collectors.joining(",")).toString();

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = scan.nextLine();
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
