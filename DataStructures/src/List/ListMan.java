package List;

import java.util.*;

public class ListMan {


    public static void main(String[] args) {
        // Tạo một ArrayList
        List<String> arrayList = new ArrayList<>();

        // Thêm phần tử vào ArrayList
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        System.out.println("Initial ArrayList: " + arrayList);

        // Thêm phần tử tại vị trí cụ thể
        arrayList.add(1, "E");
        System.out.println("After adding E at index 1: " + arrayList);

        // Lấy phần tử tại vị trí cụ thể
        String elementAtIndex2 = arrayList.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);

        // Thay thế phần tử tại vị trí cụ thể
        arrayList.set(2, "F");
        System.out.println("After setting index 2 to F: " + arrayList);

        // Xóa phần tử tại vị trí cụ thể
        arrayList.remove(2); // Xóa phần tử tại vị trí thứ 2 (0-based index)
        System.out.println("After removing element at index 2: " + arrayList);

        // Xóa phần tử theo giá trị
        arrayList.remove("D");
        System.out.println("After removing element D: " + arrayList);

        // Kiểm tra xem một phần tử có tồn tại trong ArrayList hay không
        boolean containsB = arrayList.contains("B");
        System.out.println("Contains B: " + containsB);

        // Lấy kích thước của ArrayList
        int size = arrayList.size();
        System.out.println("Size of ArrayList: " + size);

        // Duyệt qua ArrayList sử dụng Iterator
        Iterator<String> iterator = arrayList.iterator();
        System.out.print("ArrayList elements using Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Duyệt qua ArrayList sử dụng ListIterator từ cuối lên đầu
        ListIterator<String> listIterator = arrayList.listIterator(arrayList.size());
        System.out.print("ArrayList elements using ListIterator (backward): ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        // Thêm tất cả các phần tử từ một Collection khác
        List<String> anotherList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("G");
        linkedList.add("K");
        anotherList.add("G");
        anotherList.add("H");
        arrayList.addAll(anotherList);
        arrayList.addAll(linkedList);
        System.out.println("After adding all elements from anotherList: " + arrayList);

        // Xóa tất cả các phần tử trong ArrayList
        arrayList.clear();
        System.out.println("After clearing the ArrayList: " + arrayList);

        // Kiểm tra xem ArrayList có trống hay không
        boolean isEmpty = arrayList.isEmpty();
        System.out.println("Is ArrayList empty: " + isEmpty);
    }
}
