package Bai1;

import java.util.*;

public class Bai2 {
    public static void main(String[] args) {
        //Tạo Arraylist kiểu dữ liệu String
        List<String> list = new ArrayList<String>();

        //Thêm phần tử vào trong List
//        list.add("Red");
//        list.add("Green");
//        list.add("Black");
//        list.add("Orange");
//        list.add("White");
        list.addAll(Arrays.asList("Red", "Green", "Black", "Orange", "White"));



        //Thư viện sort theo comparater mặc định
        Collections.sort(list);
        System.out.println(list);
//        //in ra List sau khi đc sắp xếp
//        for (String s : list) {
//            System.out.println(s);
//        }

    }
}
