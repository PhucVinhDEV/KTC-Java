package Hackerank;

import java.util.List;

public class HackMain {
    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here

        return ar.stream().mapToLong(Long::longValue).sum();
    }

    public static void main(String[] args) {

    }
}
