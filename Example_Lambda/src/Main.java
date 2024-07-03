import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
                public static boolean isPrime(int number) {
                if (number <= 1) {
                    return false;
                }
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        return false;
                    }
                }
                return true;
            }
            public static void main(String[] args) {

                BaiTap1 b = (t) -> {
                    List<Integer> factors  = new ArrayList<>();
                    for (int i = 1; i < t; i++) {
                        if (t % i == 0) {
                            factors.add(i);
                        }
                    }
                Optional<Integer> rs =   factors.stream().filter(Main::isPrime).reduce(Integer::max);
                return rs.orElse(0);
                };


                System.out.println(b.LargestPrime(176));


                System.out.println("bai 2");
                Bai2 b2 = (t) ->
                {
                    StringBuilder result = new StringBuilder();
                    while (t>0){
                       int i = t % 2;
                       result.insert(0,i);
                       t /= 2;
                    }
                    return result.toString();
                };
                Bai2 bai2 = Integer::toBinaryString;

                System.out.println(bai2.convertToBinary(747));
                System.out.println(b2.convertToBinary(747));
            }
}