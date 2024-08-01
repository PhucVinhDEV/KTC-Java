package org.example.Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Entity.*;
import org.example.Implement.ProductAttributeServiceImplement;
import org.example.Implement.ProductImplement;
import org.example.Implement.WareHouseImplement;
import org.example.Service.ProductAttributeService;
import org.example.Service.ProductService;
import org.example.Service.WareHouseService;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ExcelHandingFile {
    private ProductService productService  = new ProductImplement();;
    private ProductAttributeService productAttributeService = new ProductAttributeServiceImplement();
    private WareHouseService wareHouseService = new WareHouseImplement();


    public void readExcelFile(String filePath) throws IOException {
        if (!Auth.isLogin()) {
            throw new RuntimeException("User is not logged in");
        }
        boolean isAdmin = Auth.getUser().getIsAdmin() == 1;

        // Sử dụng warehouseId từ đối số truyền vào nếu người dùng là admin, nếu không sử dụng warehouseId của người dùng
        String userWarehouseId;
        if (isAdmin){
            List<WareHouse>  list = wareHouseService.findAll();

            if (list.isEmpty()) {
                throw new RuntimeException("No warehouses found for admin.");
            }

            System.out.println("Please select a warehouse to import products:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". Warehouse ID: " + list.get(i).getWarehouseId() + ", Name: " + list.get(i).getWarehouseName());
            }

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice < 1 || choice > list.size()) {
                throw new RuntimeException("Invalid choice.");
            }

            userWarehouseId = list.get(choice - 1).getWarehouseId();

        }else {
            userWarehouseId = Auth.getUserWarehouses().get(0).getWarehouseId();
        }
        try (FileInputStream fileIn = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 5; i <= sheet.getLastRowNum(); i++) { // Assuming data starts from the 5th row
                Row row = sheet.getRow(i);

                if (row == null || row.getCell(1) == null) {
                    continue;
                }

                String productName = row.getCell(1).getStringCellValue();
                String description = row.getCell(2).getStringCellValue();
                int quantity = (int) row.getCell(3).getNumericCellValue();
                BigDecimal price = new BigDecimal(row.getCell(4).getNumericCellValue());
                Product product = new Product(Random.generateRandomId(), productName, userWarehouseId);
                productService.saveProduct(product);

                Product savedProduct = productService.findProductById(product.getProductId()); // Get the saved product to use its ID

                ProductAttributeString descriptionAttribute = new ProductAttributeString(savedProduct.getProductId(), "DiQo3p9N", description);
                ProductAttributeInteger quantityAttribute = new ProductAttributeInteger(savedProduct.getProductId(), "9jxG3xl6", quantity);
                ProductAttributeBigDecimal priceAttribute = new ProductAttributeBigDecimal(savedProduct.getProductId(), "MBoHgeAv", price);

                productAttributeService.saveProductAttributeString(descriptionAttribute);
                productAttributeService.saveProductAttributeInt(quantityAttribute);
                productAttributeService.saveProductAttributeBigDecimal(priceAttribute);
            }
        }

    }
}
