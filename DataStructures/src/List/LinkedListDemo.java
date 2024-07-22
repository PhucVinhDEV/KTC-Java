import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Tạo một LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Thêm phần tử vào LinkedList
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println("Initial LinkedList: " + linkedList);

        // Thêm phần tử vào đầu và cuối
        linkedList.addFirst("First");
        linkedList.addLast("Last");
        System.out.println("After adding First and Last: " + linkedList);

        // Lấy phần tử đầu và cuối
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

        // Xóa phần tử đầu và cuối
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After removing First and Last: " + linkedList);

        // Xóa phần tử tại vị trí cụ thể
        linkedList.remove(2); // Xóa phần tử tại vị trí thứ 2 (0-based index)
        System.out.println("After removing element at index 2: " + linkedList);

        // Thêm phần tử tại vị trí cụ thể
        linkedList.add(2, "E");
        System.out.println("After adding E at index 2: " + linkedList);

        // Kiểm tra xem một phần tử có tồn tại trong LinkedList hay không
        System.out.println("Contains B: " + linkedList.contains("B"));

        // Lấy phần tử tại vị trí cụ thể
        System.out.println("Element at index 2: " + linkedList.get(2));

        // Thay thế phần tử tại vị trí cụ thể
        linkedList.set(2, "F");
        System.out.println("After setting index 2 to F: " + linkedList);

        // Duyệt qua LinkedList sử dụng ListIterator
        ListIterator<String> iterator = linkedList.listIterator();
        System.out.print("LinkedList elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Thêm tất cả các phần tử từ một Collection khác
        LinkedList<String> anotherList = new LinkedList<>();
        anotherList.add("G");
        anotherList.add("H");
        linkedList.addAll(anotherList);
        System.out.println("After adding all elements from anotherList: " + linkedList);

        // Xóa tất cả các phần tử trong LinkedList
        linkedList.clear();
        System.out.println("After clearing the LinkedList: " + linkedList);

        // Kiểm tra xem LinkedList có trống hay không
        System.out.println("Is LinkedList empty: " + linkedList.isEmpty());
    }
}
