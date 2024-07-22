package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo { public static void main(String[] args) {
    // Tạo một Queue sử dụng LinkedList
    Queue<String> queue = new LinkedList<>();

    // Thêm phần tử vào Queue
    queue.add("A");
    queue.add("B");
    queue.add("C");
    queue.add("D");
    System.out.println("Initial Queue: " + queue);

    // Lấy và xoá phần tử đầu tiên (phần tử ở đầu Queue)
    String removedElement = queue.poll();
    System.out.println("Removed element: " + removedElement);
    System.out.println("Queue after poll: " + queue);

    // Lấy phần tử đầu tiên mà không xoá nó
    String headElement = queue.peek();
    System.out.println("Element at head: " + headElement);
    System.out.println("Queue after peek: " + queue);

    // Thêm phần tử vào Queue (cách khác sử dụng offer)
    queue.offer("E");
    System.out.println("Queue after offer: " + queue);

    // Kiểm tra xem Queue có rỗng không
    boolean isEmpty = queue.isEmpty();
    System.out.println("Is Queue empty: " + isEmpty);

    // Lấy kích thước của Queue
    int size = queue.size();
    System.out.println("Size of Queue: " + size);

    // Duyệt qua Queue sử dụng Iterator
    System.out.print("Queue elements using Iterator: ");
    for (String element : queue) {
        System.out.print(element + " ");
    }
    System.out.println();
}
}
