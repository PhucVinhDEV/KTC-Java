package Stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println("Initial Stack: " + stack);

        //Lấy phần tử đầu tiên (phần tử trên cùng) mà không xoá nó:
        String topElement = stack.peek();
        System.out.println("Element at top: " + topElement);
        System.out.println("Stack after peek: " + stack);

        //Lấy và xoá phần tử đầu tiên (phần tử trên cùng):
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);

        boolean isEmpty = stack.empty();
        System.out.println("Is Stack empty: " + isEmpty);

        //Tìm vị trí của phần tử trong Stack:
        int position = stack.search("B");
        System.out.println("Position of element 'B': " + position);


        System.out.print("Stack elements using Iterator: ");
        for (String element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
