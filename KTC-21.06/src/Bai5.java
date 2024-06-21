import java.util.Scanner;

public class Bai5 {
    public void solution(String strg1, String strg2){
        //String
        String str1 =strg1;
        String str2 =strg2;

        strg1 = strg1 + strg2;
        strg2 = str1.substring(0,strg1.length()-strg2.length());
        strg1 = strg1.substring(strg2.length());

        System.out.print(strg1);
        System.out.print(strg2);
    }

}
