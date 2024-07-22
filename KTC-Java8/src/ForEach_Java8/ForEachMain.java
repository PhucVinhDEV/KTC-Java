package ForEach_Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        // Tạo một Stream từ List và sử dụng forEach()
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);;

        // Tạo một Stream song song và sử dụng forEach()
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::println);


        int[] numbers = {1, 2, 3, 5, 9};
         int sum =   Arrays.stream(numbers).sum();
        int index = Arrays.binarySearch(numbers, 3);
        System.out.println("Index of 3: " + index);
        System.out.println(sum);
    }
}
