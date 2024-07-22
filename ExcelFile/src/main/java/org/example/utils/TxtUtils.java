package org.example.utils;

import org.example.Students;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtUtils {
    public static List<Students> readerFile(String fileName) {
        BufferedReader reader = null;
        List<Students> studentsList = new ArrayList<>(); // Danh sách để lưu trữ các tên

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length > 1) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    studentsList.add(new Students(id, name));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return studentsList;
    }

}
