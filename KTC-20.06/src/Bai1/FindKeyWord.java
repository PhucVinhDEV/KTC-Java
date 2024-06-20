package Bai1;

import java.util.*;

public class FindKeyWord {
    static String setInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your string: ");
        String inputString = scanner.nextLine();
        return inputString;
    }
    static Character Solution1(String key){
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Duyệt qua chuỗi key và đếm số lần xuất hiện của mỗi ký tự
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            // Đếm số lần xuất hiện của ký tự hiện tại
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            } else {
                charCount.put(currentChar, 1);
            }
        }

        // Duyệt lại chuỗi key để tìm ký tự đầu tiên có số lần xuất hiện là 1
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            // Nếu ký tự có số lần xuất hiện là 1, trả về ký tự đó
            if (charCount.get(currentChar) == 1) {
                return currentChar;
            }
        }

        // Nếu không tìm thấy ký tự không lặp lại, có thể xử lý một cách thích hợp tại đây
        return '\0'; // Hoặc
    }
//
    static Character Solution2(String key){

        int index = -1;
        char fnc = ' ';

        if(key.length()==0){
            System.out.println("EMPTY STRING");
        }

        for (char i : key.toCharArray()) {
            if (key.indexOf(i) == key.lastIndexOf(i)) {
                fnc = i;
                break;
            }
            else {
                index += 1;
            }
        }
        if (index == key.length()-1) {
            System.out.println("All characters are repeating");
        }
        else {
            System.out.println("The first non repeated characted in String is :" + fnc);
        }
        return fnc;
    }
    public static void main(String[] args) {

//        "gibblegabbler"
        String input = setInput();
        System.out.println("The given string is: "+input);
        System.out.println("The first non repeated characted in String is :" + Solution1(input));
        Solution2(input);
    }
}
