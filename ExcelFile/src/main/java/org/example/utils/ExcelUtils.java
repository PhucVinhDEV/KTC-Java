package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.Staff;
import org.example.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ExcelUtils {
    private static final String FILE_PATH = "NewFile.xlsx";

    public static void writeExcelFile() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        cell1.setCellValue("Hello");
        cell2.setCellValue("World");

        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
            workbook.write(fileOut);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        workbook.close();
    }
    public static String[] readExcelFile() throws IOException {
        String[] result = new String[2];

        try (FileInputStream fileIn = new FileInputStream(FILE_PATH)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);

            result[0] = row.getCell(0).getStringCellValue();
            result[1] = row.getCell(1).getStringCellValue();

            workbook.close();
        }

        return result;
    }
    public static List<Staff> readStaffExcelFile() throws IOException {
        List<Staff> result = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("example.xlsx")) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Staff staff = new Staff();
                Row row = sheet.getRow(i);
                staff.setName(row.getCell(0).getStringCellValue());
                staff.setAge((int)row.getCell(1).getNumericCellValue());
                staff.setGender(row.getCell(2).getStringCellValue());
                staff.setSalary((long)(row.getCell(3).getNumericCellValue()));
                result.add(staff);
            }
        }
        return result;
    }
    public static void writeStaffExcelFile(List<Staff> staffList,String fileName) throws IOException {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");
        // Create the header row
        Row headerRow = sheet.createRow(0);

        // Create a cell style for the header
        CellStyle headerCellStyle = workbook.createCellStyle();

        // Create a font for the header
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 20);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create header cells and set their style
        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("Name");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Age");
        cell2.setCellStyle(headerCellStyle);

        Cell cell3 = headerRow.createCell(2);
        cell3.setCellValue("Gender");
        cell3.setCellStyle(headerCellStyle);

        Cell cell4 = headerRow.createCell(3);
        cell4.setCellValue("Salary");
        cell4.setCellStyle(headerCellStyle);
            for (int i = 1; i <= staffList.size(); i++){
                Row rownew = sheet.createRow(i);
                rownew.createCell(0).setCellValue(staffList.get(i-1).getName());
                rownew.createCell(1).setCellValue(staffList.get(i-1).getAge());
                rownew.createCell(2).setCellValue(staffList.get(i-1).getGender());
                rownew.createCell(3).setCellValue(staffList.get(i-1).getSalary());
            }
        try (FileOutputStream fileOut = new FileOutputStream(fileName,true)) {
            workbook.write(fileOut);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        workbook.close();
    }
    public static void writeStudentExcelFile(List<Students> studentsList,String fileName) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        // Create the header row
        Row headerRow = sheet.createRow(0);

        // Create a cell style for the header
        CellStyle headerCellStyle = workbook.createCellStyle();

        // Create a font for the header
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create header cells and set their style
        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("STT");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Name");
        cell2.setCellStyle(headerCellStyle);

        for (int i = 1; i <= studentsList.size(); i++){
            Row rownew = sheet.createRow(i);
            rownew.createCell(0).setCellValue(studentsList.get(i-1).getId());
            rownew.createCell(1).setCellValue(Base64.getEncoder().encodeToString(studentsList.get(i-1).getName().getBytes()));
//            rownew.createCell(1).setCellValue(studentsList.get(i-1).getName());
        }
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        workbook.close();
    }
    public static List<Students> readStudentExcelFile(String filename) throws IOException {
        List<Students> result = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filename)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Students student = new Students();
                Row row = sheet.getRow(i);
                student.setId((int)row.getCell(0).getNumericCellValue());
                student.setName(Base64.getEncoder().encodeToString(row.getCell(1).getStringCellValue().getBytes()));
                result.add(student);
            }
        }
        return result;
    }

}
