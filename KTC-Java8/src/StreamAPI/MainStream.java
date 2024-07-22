package StreamAPI;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Vinh"));
        students.add(new Student(2,null));
        students.add(new Student(3,"Duong"));
        students.add(null);



        students.stream().filter(Objects::nonNull)
                .sorted(Comparator.comparing(Student::getName,Comparator.nullsLast(Comparator.naturalOrder())))
                .forEach(System.out::println);






//        students.stream().filter(Objects::nonNull) // Lọc bỏ các đối tượng null
//                .sorted(Comparator.comparing(
//                Student::getName,Comparator.nullsLast(Comparator.naturalOrder())))
//                .forEach(System.out::println);

//
//
//
//        List<Integer> numbers = Arrays.asList(10, 20, 0, 30);
//
//        numbers.stream()
//                .filter(n -> n != 0) // Lọc bỏ giá trị bằng 0
//                .map(n -> 100 / n)
//                .forEach(System.out::println);
//
//
//        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
//
//        List<String> result = myList.stream()
//                .filter(s -> s.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());
//        result.forEach(System.out::println);
//
//
//
//        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Sử dụng reduce để tính tổng các phần tử
//        Optional<Integer> sum = number.stream()
//                .reduce((a, b) -> a + b);
//
//        // In ra tổng các phần tử nếu có giá trị
//        sum.ifPresent(System.out::println);  // Output: 15
//
//        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Sử dụng reduce với giá trị khởi đầu để tính tổng các phần tử
//        int total = numbers.stream()
//                .reduce(0, (a, b) -> a + b);
//
//        // In ra tổng các phần tử
//        System.out.println(total);  // Output: 15
//
//        List<Integer> numb = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Sử dụng reduce để tính tích các phần tử
//        Optional<Integer> product = numb.stream()
//                .reduce((a, b) -> a * b);
//
//        // In ra tích các phần tử nếu có giá trị
//        product.ifPresent(System.out::println);  // Output: 120

//        List<String> list = Arrays.asList("J", "a", "v", "a", " ", "M", "a", "g", "a", "z", "i", "n", "e");
//        List<String> list = Arrays.asList("Java", "Magazine");

//
//        list.stream()
//                .map(s -> s.split(""))           // Chia chuỗi thành mảng các ký tự
//                .flatMap(Arrays::stream)         // "Làm phẳng" các mảng thành Stream các ký tự
//                .distinct()                      // Loại bỏ các ký tự trùng lặp
//                .collect(Collectors.toList())    // Thu thập các ký tự vào một List
//                .forEach(System.out::print);
//
//        System.out.println();
//
//        list.parallelStream()
//                .map(s -> s.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::print);
        List<String> list = Arrays.asList("Java", "Magazine");

        // Sử dụng Stream thông thường
        System.out.print("Sequential Stream: ");
        list.stream()
                .map(s -> s.split(""))           // Chia chuỗi thành mảng các ký tự
                .flatMap(Arrays::stream)         // "Làm phẳng" các mảng thành Stream các ký tự
                .distinct()                      // Loại bỏ các ký tự trùng lặp
                .collect(Collectors.toList())    // Thu thập các ký tự vào một List
                .forEach(System.out::print);     // In các ký tự

        System.out.println();

        // Sử dụng Parallel Stream
        System.out.print("Parallel Stream: ");
        list.parallelStream()
                .map(s -> s.split(""))           // Chia chuỗi thành mảng các ký tự
                .flatMap(Arrays::stream)         // "Làm phẳng" các mảng thành Stream các ký tự
                .distinct()                      // Loại bỏ các ký tự trùng lặp
                .collect(Collectors.toList())    // Thu thập các ký tự vào một List
                .forEach(System.out::print);     // In các ký tự

        System.out.println();


        //Test Daluong trong stream


        // Tạo một mảng lớn chứa các số nguyên
        int[] numbers = new int[1000000];
        Arrays.fill(numbers, 1); // Gán tất cả các phần tử trong mảng là số 1

        // Sử dụng Stream thông thường để tính tổng
        long startTime = System.currentTimeMillis();
        long sumSequential = Arrays.stream(numbers)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sum using Sequential Stream: " + sumSequential);
        System.out.println("Time taken by Sequential Stream: " + (endTime - startTime) + " milliseconds");

        // Sử dụng Parallel Stream để tính tổng
        startTime = System.currentTimeMillis();
        long sumParallel = Arrays.stream(numbers)
                .parallel()
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Sum using Parallel Stream: " + sumParallel);



        List<String> languageList = Arrays.asList("Java", "Magazine", "PHP", "C#");

        // Sử dụng Stream tuần tự với forEach
        System.out.print("Sequential Stream with forEach: ");
        languageList.stream().forEach(System.out::print);
        System.out.println();

        // Sử dụng Stream tuần tự với forEachOrdered
        System.out.print("Sequential Stream with forEachOrdered: ");
        languageList.stream().forEachOrdered(System.out::print);
        System.out.println();

        // Sử dụng Parallel Stream với forEach
        System.out.print("Parallel Stream with forEach: ");
        languageList.parallelStream().forEach(System.out::print);
        System.out.println();

        // Sử dụng Parallel Stream với forEachOrdered
        System.out.print("Parallel Stream with forEachOrdered: ");
        languageList.parallelStream().forEachOrdered(System.out::print);
        System.out.println();

//        List<Double> listDouble = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
//        Double avg = listDouble.stream()
//                .mapToDouble(Double::doubleValue)
//                .average().orElse(0.0);
//        System.out.println("Avg: " + avg);

        //tinh tong cac so chan
        List<Integer> listSum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = listSum.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
        System.out.println(result);

        //Cho một danh sách các chuỗi. Hãy chuyển đổi tất cả các chuỗi thành chữ in hoa và nối chúng lại thành một chuỗi duy nhất.
        List<String> words = Arrays.asList("java", "stream", "api", "example");
        String resultne =  words.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(resultne);

        //Cho một danh sách các số thực. Hãy tìm giá trị nhỏ nhất và giá trị lớn nhất trong danh sách
        List<Double> listdouble = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        Optional<Double> max = listdouble.stream().max(Double::compareTo);
        Optional<Double> min = listdouble.stream().min(Double::compareTo);
        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);

        //Cho một danh sách các số nguyên, hãy sử dụng Stream API để tìm tất cả các số chẵn và in chúng ra.
        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        listInteger.stream().filter(t -> t%2 ==0).forEach(System.out::println);

        //Cho một danh sách các chuỗi, hãy sử dụng Stream API để tìm tất cả các chuỗi có độ dài lớn hơn 3 và thu thập chúng vào một danh sách mới.
        words.stream().filter(t -> t.length()>3).forEach(System.out::println);

        double doubleSum = listdouble.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println(doubleSum);

        long count = words.stream().count();
        System.out.println(count);

        listInteger.stream().map(String::valueOf).toList().forEach(System.out::print);
    }
}
