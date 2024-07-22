package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriteReader {
    public static List<String> readerFile(String fileName) {
        BufferedReader reader = null;
        List<String> namesList = new ArrayList<>(); // Danh sách để lưu trữ các tên

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // Tách dòng theo khoảng trắng và chỉ lấy phần tên
                String[] parts = line.split("\\s+", 2); // Tách dòng theo khoảng trắng, giới hạn tách thành 2 phần
                if (parts.length == 2) {
                    namesList.add(parts[1]); // Thêm tên (phần thứ hai sau khi tách) vào danh sách
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Không thể đọc từ file " + fileName, e);
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Đóng BufferedReader sau khi đọc xong
                }
            } catch (IOException e) {
                e.printStackTrace(); // Xử lý ngoại lệ khi đóng BufferedReader
            }
        }
        return namesList;
    }
}
