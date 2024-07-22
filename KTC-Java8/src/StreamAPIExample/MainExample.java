package StreamAPIExample;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 20, Arrays.asList("Math", "Physics")));
        people.add(new Person("Bob", 22, Arrays.asList("Chemistry", "Biology")));
        people.add(new Person("Charlie", 23, Arrays.asList("Math", "Chemistry")));
        people.add(new Person("David", 21, Arrays.asList("Physics", "Biology")));
        people.add(new Person("Eve", 24, Arrays.asList("Math", "Computer Science")));
        people.add(new Person("Frank", 25, Arrays.asList("Biology", "Chemistry")));
        people.add(new Person("Grace", 26, Arrays.asList("Physics", "Computer Science")));
        people.add(new Person("Hank", 27, Arrays.asList("Math", "Biology")));
        people.add(new Person("Ivy", 28, Arrays.asList("Chemistry", "Physics")));
        people.add(new Person("Jack", 29, Arrays.asList("Computer Science", "Biology")));


//        Bài tập 1: Lọc danh sách theo độ tuổi
//        Viết mã để lọc và in ra danh sách các đối tượng Person có độ tuổi lớn hơn 25.
            //su dung Predicate
        System.out.println(" Bài tập 1: Lọc danh sách theo độ tuổi");
        Predicate<Person> checkAge = person -> person.getAge() > 25;
        people.stream().filter(checkAge).forEach(System.out::println);
        // Tính độ tuổi trung bình của các đối tượng Person
       people.stream()
                .mapToInt(Person::getAge)
                .average().ifPresent(System.out::println);
//        Bài tập 2: Lấy danh sách tên
//        Sử dụng Stream API để lấy danh sách tên của tất cả các Person và in ra danh sách đó.
        System.out.println(" Bài tập 2: Lấy danh sách tên");
            people.stream().map(Person::getName).forEach(System.out::println);

//        Bài tập 3: Đếm số lượng khóa học
//        Viết mã để đếm tổng số khóa học mà tất cả các Person tham gia.

        // Đếm tổng số khóa học mà tất cả các Person tham gia
//        long totalCourses = people.stream()
//                .flatMap(person -> person.getCourse().stream())
//                .count();
            long totalCourses =people.stream().flatMap(p -> p.getCourse().stream()).count();
        System.out.println("Total number of courses: " + totalCourses);


//        Bài tập 4: Lấy danh sách các khóa học duy nhất
//        Sử dụng Stream API để lấy danh sách các khóa học duy nhất mà tất cả các Person tham gia.
        // Bài tập 4: Lấy danh sách các khóa học duy nhất mà tất cả các Person tham gia
        Set<String> uniqueCourses = people.stream()
                .flatMap(person -> person.getCourse().stream())
                .collect(Collectors.toSet());
        System.out.println(uniqueCourses);
//        Bài tập 5: Sắp xếp danh sách theo tên
//        Viết mã để sắp xếp danh sách Person theo tên và in ra danh sách đã sắp xếp.
            System.out.println("Bài tập 5: Sắp xếp danh sách theo tên");
                people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);

//        Bài tập 6: Tính độ tuổi trung bình
//        Sử dụng Stream API để tính và in ra độ tuổi trung bình của các Person.
        System.out.println(" Bài tập 6: Tính độ tuổi trung bình");
                people.stream().mapToInt(Person::getAge).average().ifPresent(System.out::println);

//        Bài tập 7: Ghép các tên lại thành một chuỗi
//        Sử dụng Stream API để ghép tất cả các tên của các Person thành một chuỗi duy nhất, ngăn cách bởi dấu phẩy.
            people.stream().map(Person::getName).collect(Collectors.joining(",")).toString();
        System.out.println("Bài tập 7: Ghép các tên lại thành một chuỗi");
        System.out.println( people.stream().map(Person::getName).collect(Collectors.joining(",")).toString());

//        Bài tập 8: Sử dụng flatMap để lấy tất cả các khóa học
//        Sử dụng flatMap để lấy tất cả các khóa học của tất cả các Person và in ra danh sách đó.
        System.out.println("Bài tập 8: Sử dụng flatMap để lấy tất cả các khóa học\n");
            people.stream().flatMap(p -> p.getCourse().stream()).forEach(System.out::println);
        // Bài tập 9: Lấy tất cả các khóa học và loại bỏ trùng lặp
        System.out.println(" Bài tập 9: Lấy tất cả các khóa học và loại bỏ trùng lặp\n");
            people.stream().flatMap(p -> p.getCourse().stream()).collect(Collectors.toSet()).forEach(System.out::print);
    }

}
