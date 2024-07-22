package StreamAPIExample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserMain {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 20, Arrays.asList("Math", "Physics"), "alice@example.com", "Female", LocalDate.of(2003, 1, 1)));
        users.add(new User("Bob", 22, Arrays.asList("Chemistry", "Biology"), "bob@example.com", "Male", LocalDate.of(2001, 2, 2)));
        users.add(new User("Charlie", 23, Arrays.asList("Math", "Chemistry"), "charlie@example.com", "Male", LocalDate.of(2000, 3, 3)));
        users.add(new User("David", 21, Arrays.asList("Physics", "Biology"), "david@example.com", "Male", LocalDate.of(2002, 4, 4)));
        users.add(new User("Eve", 24, Arrays.asList("Math", "Computer Science"), "eve@example.com", "Female", LocalDate.of(1999, 5, 5)));
        users.add(new User("Frank", 25, Arrays.asList("Biology", "Chemistry"), "frank@example.com", "Male", LocalDate.of(1998, 6, 6)));
        users.add(new User("Grace", 26, Arrays.asList("Physics", "Computer Science"), "grace@example.com", "Female", LocalDate.of(1997, 7, 7)));
        users.add(new User("Hank", 27, Arrays.asList("Math", "Biology"), "hank@example.com", "Male", LocalDate.of(1996, 8, 8)));
        users.add(new User("Ivy", 28, Arrays.asList("Chemistry", "Physics"), "ivy@example.com", "Female", LocalDate.of(1995, 9, 9)));
        users.add(new User("Jack", 29, Arrays.asList("Computer Science", "Biology"), "jack@example.com", "Male", LocalDate.of(1994, 10, 10)));

//        Bài tập 1: Lọc danh sách theo giới tính
//        Viết mã để lọc và in ra danh sách các đối tượng User theo giới tính.
        System.out.println("Bài tập 1: Lọc danh sách theo giới tính\n");
        users.stream().filter(t -> t.getGender().equals("Female")).forEach(System.out::println);

//        Bài tập 2: Tìm người lớn tuổi nhất
//        Sử dụng Stream API để tìm và in ra thông tin của người lớn tuổi nhất trong danh sách.
        System.out.println("Bài tập 2: Tìm người lớn tuổi nhất");
            users.stream().mapToInt(User::getAge).max().ifPresent(System.out::println);


//                Bài tập 3: Tính số ngày đến sinh nhật tiếp theo
//        Viết mã để tính và in ra số ngày còn lại đến sinh nhật tiếp theo của mỗi người.
        System.out.println("Bài tập 3: Tính số ngày đến sinh nhật tiếp theo");

        users.forEach(user -> {
            LocalDate today = LocalDate.now();
            LocalDate nextBirthday = user.getBirthDate().withYear(today.getYear());

            if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            long daysUntilNextBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
            System.out.println(user.getName() + ": " + daysUntilNextBirthday + " ngày");
        });

//                Bài tập 4: Đếm số lượng khóa học của từng giới tính
//        Sử dụng Stream API để đếm tổng số khóa học của từng giới tính và in ra kết quả.
        System.out.println("Bài tập 4: Đếm số lượng khóa học của từng giới tính");
        long count = users.stream().filter(t -> t.getGender().equals("Female")).flatMap(u -> u.getCourses().stream()).distinct().count();
        System.out.println(" Count "+ count);
//                Bài tập 5: Tạo danh sách email
//        Sử dụng Stream API để tạo và in ra danh sách tất cả các địa chỉ email của những người trên 25 tuổi.
        System.out.println(" Bài tập 5: Tạo danh sách email");
                    users.stream().filter(t -> t.getAge()>25).map(User::getEmail).forEach(System.out::println);

//                Bài tập 6: Sắp xếp theo ngày sinh
//        Viết mã để sắp xếp danh sách User theo ngày sinh và in ra danh sách đã sắp xếp.
        System.out.println("Bài tập 6: Sắp xếp theo ngày sinh");
            users.stream().sorted(Comparator.comparing(User::getBirthDate)).forEach(System.out::println);


//                Bài tập 7: Tính độ tuổi trung bình theo giới tính
//        Sử dụng Stream API để tính và in ra độ tuổi trung bình của từng giới tính.
        System.out.println("Bài tập 7: Tính độ tuổi trung bình theo giới tính");
        users.stream().filter(t -> t.getGender().equals("Female")).mapToInt(User::getAge).average().ifPresent(System.out::println);



    }


}
