package FucinalInterface;

import com.sun.tools.javac.Main;

import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class RunTest {
    public static <T> void printf(T[] array){
        for(T t : array){
            System.out.println(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello")); // Output: 5


        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(12));

        // Triển khai DoubleToLongFunction bằng cách sử dụng một lớp ẩn danh
        DoubleToLongFunction doubleToLong = new DoubleToLongFunction() {
            @Override
            public long applyAsLong(double value) {
                // Chuyển đổi giá trị double thành long bằng cách nhân với 1000 và ép kiểu
                return (long) (value * 1000);
            }
        };
        // Triển khai DoubleToLongFunction bằng biểu thức lambda
       DoubleToLongFunction doubletolong = value -> (long) value*1000;

        // Sử dụng hàm applyAsLong
        double input = 123.45;
        long result = doubletolong.applyAsLong(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);

        Dog dog = new Dog("Duy",13);

        Box<Dog> dogBox = new Box<>();
        dogBox.setElement(dog);
        System.out.println(dogBox.getElement().getAge());

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D"};


        printf(intArray);
        printf(strArray);


        ImplementInterface<String> stringList = new ImplementInterface<>();
        stringList.add("Hello");
        stringList.add("World");

        System.out.println(stringList.get(0)); // Output: Hello
        System.out.println(stringList.get(1)); // Output: World

        ImplementInterface<Integer> integerList = new ImplementInterface<>();
        integerList.add(1);
        integerList.add(2);

        System.out.println(integerList.get(0)); // Output: 1
        System.out.println(integerList.get(1)); // Output: 2
    }
}
