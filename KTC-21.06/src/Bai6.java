import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public List<Integer> Inputdata(){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("How Many numbers do you want to input?");
        int n = sc.nextInt();
        System.out.println("Input the Integer:");
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        return list;
    }
    public String Solution6(List<Integer> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == list.get(i)) {
                    throw new RuntimeException("Error: Duplicate Number found:" +i + "  And Index " + j);
                }
            }
        }
        result = "No Dupplicate Number!";
        return result;
    }
}
