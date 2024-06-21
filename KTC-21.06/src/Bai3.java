import java.util.Scanner;

public class Bai3 {
    public void solutionBai3(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int n=0;
        int m =0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                n++;
            }else {
                m++;
            }
        }
        System.out.println("So phan tu chan la: "+n + " So phan tu le la :"+m);
    }

}
