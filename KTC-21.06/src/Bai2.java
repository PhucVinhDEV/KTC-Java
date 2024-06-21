public class Bai2 {
    public void Solution(String str){
        StringBuilder strg = new StringBuilder();
        for (char i :  str.toCharArray()) {
            strg.append(i);
            strg.append(i);
        }
        System.out.println(strg.toString());
    }

}
