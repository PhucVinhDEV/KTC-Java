package MethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaExample {
    public static void main(String[] args) {
        Supplier<List<String>> listSupplier = ArrayList::new;

        List<String> list = listSupplier.get();

        list.add("Hello");
        list.add("World");

        list.forEach(System.out::println);
    }
}
