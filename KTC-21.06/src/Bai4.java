import java.util.HashSet;
import java.util.Set;

public class Bai4 {
    public void SolutionBai4(){
        StringBuilder sb = new StringBuilder("characters");
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for(char c : sb.toString().toCharArray()){
            if(!seen.contains(c)){
                result.append(c);
                seen.add(c);
            }

        }
        System.out.println(result);
    }

}
