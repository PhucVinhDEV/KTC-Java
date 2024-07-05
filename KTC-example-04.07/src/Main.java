import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static boolean ispalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
           if (chars[i] != chars[chars.length-1-i]){
               return false;
           }
        }
        return true;
    }


    public static void main(String[] args) {

        //Bai 1
        List<Double> listDouble = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        Double avg = listDouble.stream()
                .mapToDouble(Double::doubleValue)
                .average().orElse(0.0);
        System.out.println("Avg: " + avg);

        //Bai 2
        List<String> list = Arrays.asList("Madam","radar","defied");
        list.stream().map(Main::ispalindrome).forEach(System.out::println);

        //Bai 3
        List<Integer> intList = Arrays.asList(1,7,18,25,77,300,101);
        intList.stream().min(Integer::compareTo).ifPresent(System.out::println);
        Optional<Integer> max = intList.stream().max(Integer::compareTo);
        intList.stream().filter( t -> t != max.get()).max(Integer::compareTo).ifPresent(System.out::println);

    }


}