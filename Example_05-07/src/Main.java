import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Bai 1
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);
        int sum = list.stream().filter(t -> t % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        int sumle = list.stream().filter(t -> t % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumle);

        //Bai 2
//        list2.stream().distinct().forEach(System.out::println);
        List<Integer> list2 = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9, 10, 12, 14);



        System.out.println("input: " );
        int valuekey = sc.nextInt();

        // Sử dụng Stream API để đếm số lần xuất hiện của mỗi phần tử trong danh sách
        Map<Integer, Long> map = list2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

   for (Map.Entry<Integer, Long> entry : map.entrySet()) {
       if (entry.getValue() == valuekey) {
           System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
       }
   }

//        Map<Integer, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < list2.size(); i++) {
//            int key = list2.get(i);
//            // Nếu phần tử đã tồn tại trong map, tăng giá trị đếm lên 1
//            if (map2.containsKey(key)) {
//                map2.put(key, map2.get(key) + 1);
//            } else {
//                // Nếu phần tử chưa tồn tại trong map, đặt giá trị đếm là 1
//                map2.put(key, 1);
//            }
//        }

//        // In kết quả ra màn hình
//        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//            if (entry.getValue() == valuekey) {
//                System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
//            }else{
//                System.out.println("Not Element");
//            }
//        }
    }
}