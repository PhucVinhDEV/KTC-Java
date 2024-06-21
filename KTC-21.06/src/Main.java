import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


//        //Demo NullPointerException
//        String str = null;
//        try {
//            System.out.println(str.toString());
//        }catch (NullPointerException e){
//            System.out.println("NullPointerException");
//        }
//
//        System.out.println("-->>> Before NullPointerException Progaming Continue");
//
//
//        // demo NumberFormatException
//        String str1 = "abc";
//        try {
//            int index = Integer.parseInt(str1);
//        }catch (NumberFormatException e){
//            System.out.println("NumberFormatException");
//        }
//
//        System.out.println("-->>> Before NumberFormatException Progaming Continue");
//
//        // Phía trên là unChecked exception => lỗi thường do người code


//            ReadFile();

//
//        String str2 = null;
//
//        try {
//            int index = Integer.parseInt(str2);
//        }catch (NumberFormatException e){
//            System.out.println("NumberFormatException");
//        }catch (NullPointerException e){
//            System.out.println("NullPointerException");
//        }finally {
//            System.out.println("finally ne");
//        }

        Bai_1 bai1 = new Bai_1();
        Bai2 bai2 = new Bai2();
        Bai3 bai3 = new Bai3();
        Bai4 bai4 = new Bai4();
        Bai5 bai5 = new Bai5();

        // Tạo một mảng Integer
        Integer[] array = {5,1, 8, 4, 9, 1, 5};

        // Chuyển đổi mảng thành danh sách
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(" Bai 1 :" + bai1.solution(list));

        System.out.println("Bai 2");
        bai2.Solution("hello");

        System.out.println("Bai 3");
        bai3.solutionBai3();

        System.out.println("Bai 4");
        bai4.SolutionBai4();

        System.out.println("Bai 5");
        bai5.solution("Hello","World");

    }




    // Demo uncheck Exception Unchecked Exeption là lỗi khách quan bắt buộc phai được khai báo
    static  void ReadFile() throws FileNotFoundException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            throw new RuntimeException();
        }catch (FileNotFoundException e){

            System.err.println("Err: FileNotFoundException");
         throw e;
        }
    }
}