import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {



        Bai_1 bai1 = new Bai_1();
        Bai2 bai2 = new Bai2();
        Bai3 bai3 = new Bai3();
        Bai4 bai4 = new Bai4();
        Bai5 bai5 = new Bai5();
        Bai6 bai6 = new Bai6();

//        // Tạo một mảng Integer
//        Integer[] array = {5,1, 8, 4, 9, 1, 5,1};
//        Integer[] array2 = { 8, 4, 9, 1, 5};
//        // Chuyển đổi mảng thành danh sách
//        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
//        System.out.println(" Bai 1 :" + bai1.solution(list));
//
//        System.out.println("Bai 2");
//        bai2.Solution("hello");
//
//        System.out.println("Bai 3");
//        bai3.solutionBai3();
//
//        System.out.println("Bai 4");
//        bai4.SolutionBai4();
//
//        System.out.println("Bai 5");
//        bai5.solution("Hello","World");
//        System.out.println();

        System.out.println("Bai 6");
        System.out.println(bai6.Solution6(bai6.Inputdata()));
        System.out.println("Ket thuc");

    }




}