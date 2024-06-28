import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] == 0 ) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }

        return arr;
    }

    static int[] moveZeroToEnd(int[] arr){
        int n = arr.length;
        int index = 0;
        for (int i = 0; i <n ; i++) {
            if (arr[i] != 0){
                arr[index++] = arr[i];
            }
        }
        while (index < n){
            arr[index++] = 0;
        }
        return arr;
    }

    static boolean checkdigit(int num) {
        // Chuyển số nguyên thành chuỗi để dễ dàng kiểm tra từng chữ số
        String nStr = Integer.toString(num);
//        String nStr = Long.toString(num);
        // Duyệt qua từng chữ số của chuỗi
        for (int i = 0; i < nStr.length(); i++) {
            // Lấy ký tự tại vị trí i và chuyển nó thành số nguyên
            int digit = Character.getNumericValue(nStr.charAt(i));

            // Kiểm tra xem chữ số có phải là số lẻ hay không
            if (digit % 2 == 0) {
                // Nếu có bất kỳ chữ số nào là số chẵn, trả về false
                return false;
            }
        }
        // Nếu tất cả các chữ số đều là số lẻ, trả về true
        return true;
    }
    static int checkFristNumber(int num) {
        // Chuyển số nguyên thành chuỗi để dễ dàng kiểm tra từng chữ số
        String nStr = Integer.toString(num);

        //Check num - / +
        if (num>0){
            //Num + lay phan tu dau thu 0
            int digit = Character.getNumericValue(nStr.charAt(0));
            return digit;
        }else {
            //Num - lay phan tu dau thu 1
            int digit = Character.getNumericValue(nStr.charAt(1));
            return -digit;
        }
    }
    static int checkFristNumber2(int num) {
        while (num>=10 || num<=-10){
            num/=10;
        }
        return num;
    }
    public static void main(String[] args) {
//        int[] arr = { 0, 0, 1, 0, 3, 0, 5, 0, 6 };
//        int[] arr1 = BubbleSort(arr);
//        Arrays.stream(arr1).forEach(System.out::print);
//        System.out.println();
//        int[] arr2 = moveZeroToEnd(arr);
//        Arrays.stream(arr2).forEach(System.out::print);
//        System.out.println();
//        System.out.println(checkdigit(1500000000));
//        System.out.println(checkFristNumber(-357));
//        System.out.println(checkFristNumber2(-35));

//        ArrayList<String> list = new ArrayList<>();
//        System.out.println(Arrays.toString(list.toArray()));

        // Khởi tạo StringBuilder với dung lượng ban đầu là 4
        StringBuilder sb = new StringBuilder(4);

        // Thêm 6 ký tự 'a' vào StringBuilder
        for (int i = 0; i < 6; i++) {
            sb.append("a");
        }

        // In ra nội dung của StringBuilder
        System.out.println(sb);  // Kết quả: aaaaaa

        // In ra dung lượng hiện tại của StringBuilder
        System.out.println("Capacity: " + sb.capacity());  // Dung lượng hiện tại

        // In ra chiều dài của chuỗi hiện tại trong StringBuilder
        System.out.println("Length: " + sb.length());  // Chiều dài của chuỗi hiện tại
    }
}