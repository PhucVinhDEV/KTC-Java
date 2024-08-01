package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelHandingFile {
    public static void readStaffExcelFile() throws IOException {

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
}
