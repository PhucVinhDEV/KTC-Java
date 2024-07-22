package org.example.utils;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.Staff;
import org.example.Students;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class WordUtils {

    public static void writeStaffWordFile(List<Staff> list, String fileNew) throws IOException {
        XWPFDocument document = new XWPFDocument(); // Tạo 1 tài liệu mới
        // Tạo 1 đoạn văn bản và thêm nội dung
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        for (Staff staff : list){
            run.setBold(true);
            run.setUnderline(UnderlinePatterns.SINGLE);
            run.setColor("FF0000"); // Red color
            run.setText(staff.toString().formatted());
            run.addBreak();
        }
        // Ghi ra file output.docx
        FileOutputStream out = new FileOutputStream(fileNew);
        document.write(out);
        document.close(); // Đóng tài liệu
        System.out.println("Đã tạo file docx thành công!");
    }

    public static void writeStudentsWordFile(List<Students> list, String fileNew) throws IOException {
        XWPFDocument document = new XWPFDocument(); // Tạo 1 tài liệu mới
        // Tạo 1 đoạn văn bản và thêm nội dung
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        for (Students student : list){
            run.setBold(true);
            run.setColor("FF0000"); // Red color
            run.setText(String.valueOf(student.getId()));
            run.addTab();
            run.setText(Base64.getEncoder().encodeToString(student.getName().getBytes()));

        }
        // Ghi ra file output.docx
        FileOutputStream out = new FileOutputStream(fileNew);
        document.write(out);
        document.close(); // Đóng tài liệu
        System.out.println("Đã tạo file docx thành công!");
    }

    public static List<Students> readStudentsWordFile(String fileName) throws IOException {
        List<Students> studentsList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                String text = paragraph.getText().trim();

                String[] parts = text.split("\t");
                if (parts.length > 1) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = String.valueOf(Base64.getDecoder().decode(parts[1].getBytes()));
                    System.out.println("name ne" + name);
                    studentsList.add(new Students(id, name));
                }
            }
        }
        System.out.println(studentsList.size());
        return studentsList;
    }
}
