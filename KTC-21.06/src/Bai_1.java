import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bai_1 {
   public int solution(List<Integer> list) {
        int res = 0;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            if (!seen.contains(list.get(i))) {
                res += list.get(i);
                seen.add(list.get(i));
            }
        }
        return res;
    }

    public int solution2(List<Integer> list) {
        int[] res = {0}; // Sử dụng mảng để lưu trữ kết quả, vì biến bên trong lambda phải là final hoặc effectively final
       list.stream().distinct().forEach(t -> res[0]+=t);
       return res[0];
    }


}
