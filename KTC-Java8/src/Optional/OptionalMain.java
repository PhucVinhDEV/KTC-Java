package Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalMain {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        // Sử dụng Function để chuyển đổi danh sách chuỗi thành danh sách độ dài của chuỗi
        Function<String, Integer> lengthFunction = String::length;
        List<Integer> lengths = strings.stream()
                .map(lengthFunction)
                .collect(Collectors.toList());

        System.out.println(lengths); // Output: [5, 6, 6]

        //Funcion - ConSumer - Suplier - predicate


        Optional<String> optionalInput = Optional.of("example@example.com");

        // Predicate: Kiểm tra giá trị nếu tồn tại
        Predicate<String> isValidEmail = email -> email.contains("9");

        // Function: Chuyển đổi giá trị nếu tồn tại
        Function<String, String> toUpperCase = String::toUpperCase;

        // Consumer: Thực hiện hành động nếu giá trị tồn tại
        Consumer<String> printMessage = System.out::println;

        // Supplier: Cung cấp giá trị mặc định nếu không có giá trị nào khác
        Supplier<String> defaultValue = () -> "Default Value";

        // Xử lý kết hợp
        optionalInput.filter(isValidEmail)
                .map(toUpperCase)
                .ifPresentOrElse(printMessage, () -> System.out.println(defaultValue.get()));
        // OUTPUT: EXAMPLE@EXAMPLE.COM

    }
}
