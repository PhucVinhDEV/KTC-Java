import java.util.Scanner;
import java.util.Stack;

public class StringExample {
   static void SolutionString(){
        System.out.print(" Input :");

        //Library input data from Client
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
            stack.push(c);
       }

       StringBuilder sb = new StringBuilder();
       while (!stack.isEmpty()) {
           sb.append(stack.pop());
       }

       // Convert StringBuilder to String
       String reversedString = sb.toString();

       // Print reversed string
       System.out.println("Reversed string: " + reversedString);
   }
    public static void main(String[] args) {
        SolutionString();
    }
}
