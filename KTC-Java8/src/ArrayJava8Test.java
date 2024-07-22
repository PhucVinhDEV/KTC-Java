import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayJava8Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        arr[0] = 1;
        arr[1] = 9;
        arr[2] = 3;
        arr[3] = 7;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 4;
        arr[7] = 8;
        arr[8] = 2;
        arr[9] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();


        //Sap xep 10 phan tu dau tien tang dan
        Arrays.parallelSort(arr,0,10);

        //sap xep 10 phan tu dau tien giam dan
        Arrays.parallelSort(arr,arr.length-10,arr.length, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
