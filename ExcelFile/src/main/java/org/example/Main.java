package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.utils.ExcelUtils;
import org.example.utils.TxtUtils;
import org.example.utils.WordUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args)  {
        // Current date
  LocalDate currentDate = LocalDate.now();

        // Define the formatter with the desired pattern
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        // Format the LocalDate
     String formattedDate = currentDate.format(formatter);



//        try {
//            ExcelUtils.writeExcelFile();
//            ExcelUtils.writeStaffExcelFile(ExcelUtils.readStaffExcelFile(),"NewStaff.xlsx");
//            ExcelUtils.writeWordFile(ExcelUtils.readStaffExcelFile(),"NewStaff.docx");
//        }catch (IOException Io){
//            System.out.println(Io);
//        }


      try {
          ExcelUtils.writeStudentExcelFile(TxtUtils.readerFile("Students.txt"),"Students"+"_"+formattedDate+".xlsx");
          WordUtils.writeStudentsWordFile(TxtUtils.readerFile("Students.txt"),"Students"+"_"+formattedDate+".docx");

//          for (Students s :ExcelUtils.readStudentExcelFile("Students_12072024.xlsx")){
//              System.out.println(s);
//          }
          System.out.println("------------");
          for (Students s :WordUtils.readStudentsWordFile("Students_12072024.docx")){
              System.out.println(s);
          }
      }catch (IOException io){
          io.printStackTrace();
      }
    }
}