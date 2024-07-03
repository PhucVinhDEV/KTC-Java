package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaMain {
    public static void main(String[] args) {

        BaseInterface b = (x,y) -> (x+y);
        System.out.println( b.timX(5,7));
        b.dontSayHello();
        BaseInterface.dontSayHello2();

        InterfaceTest i = (a) -> {
            System.out.println(a);
        };
        i.print(1);

        InterfaceTest i1 = System.out::println;
        i1.print(1);


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.forEach(System.out::println);

        Function<String, Integer> f = new Function<>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        Function<String, Integer> f1 = (x) -> Integer.parseInt(x);

        Function<String,Integer> f2 = Integer::parseInt;
    }
}
