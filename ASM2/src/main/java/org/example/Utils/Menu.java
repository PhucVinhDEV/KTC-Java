package org.example.Utils;
import org.example.DTO.WarehouseAccountReponseeDTO;
import org.example.Entity.Account;
import org.example.Entity.AccountWarehouse;
import org.example.Entity.WareHouse;
import org.example.Implement.AccountImplement;
import org.example.Implement.AccountWareHouseImpl;
import org.example.Implement.WareHouseImplement;
import org.example.Service.AccountService;
import org.example.Service.AccountWareHouseService;
import org.example.Service.WareHouseService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Menu {

    AccountService accountService = new AccountImplement();
    WareHouseService wareHouseService = new WareHouseImplement();
    AccountWareHouseService accountWareHouseService = new AccountWareHouseImpl();
    Scanner sc = new Scanner(System.in);


    public void mainMenu() throws IOException {
        while (true) {
            login();
            if (Auth.isLogin() && Auth.user.getIsAdmin() == 1) {
                adminMenu();
            } else if (Auth.isLogin()) {
                userMenu();
            } else {
                System.out.println("Login fail ");
            }
        }
    }

    private void adminMenu() throws IOException {
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Warehouses");
            System.out.println("3. Import Products from Excel");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    manageWarehouses();
                    break;
                case 3:
                    importProducts();
                    break;
                case 0:
                    accountService.Logout();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void userMenu() throws IOException {
        while (true) {
            System.out.println("User Menu");
            System.out.println("1. View Products");
            System.out.println("2. Import Products from Excel");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    importProducts();
                    break;
                case 0:
                    accountService.Logout();
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void manageUsers() {
        while (true) {
            System.out.println("Managing users...");
            System.out.println("1. Create User");
            System.out.println("2. Read Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    readUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void deleteUser() {
        List<Account> users = accountService.GetAllAccounts();
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("Select a user to delete:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getUsername() + " (" + users.get(i).getEmail() + ")");
        }

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice < 1 || choice > users.size()) {
            System.out.println("Invalid choice.");
        } else {
            Account userToDelete = users.get(choice - 1);
            accountService.DeleteAccount(userToDelete);
            System.out.println("User deleted successfully.");
        }
    }

    private void updateUser() {
        List<Account> users = accountService.GetAllAccounts();
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("Select a user to update password:");
        for (int i = 0; i < users.size(); i++) {
            Account user = users.get(i);
            System.out.println((i + 1) + ". " + user.getUsername() + " - " + user.getEmail());
        }

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice < 1 || choice > users.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Account userToUpdate = users.get(choice - 1);

        System.out.print("Enter new password: ");
        String password = sc.nextLine();
        userToUpdate.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));

        accountService.UpdateAccount(userToUpdate);
        System.out.println("User password updated successfully.");
    }

    private void readUsers() {
        List<Account> users = accountService.GetAllAccounts();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("User List:");
            for (Account user : users) {
                System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail() + ", Is Admin: " + (user.getIsAdmin() == 1 ? "Yes" : "No"));
            }
        }
    }

    private void createUser() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        sc.nextLine(); // Consume newline

        Account newUser = new Account(Random.generateRandomId(), Base64.getEncoder().encodeToString(password.getBytes()), email, 0);
        accountService.CreateAccount(newUser);
        System.out.println("User created successfully.");
    }

    private void manageWarehouses() {
        while (true) {
            System.out.println("Managing warehouses...");
            System.out.println("1. Create Warehouse");
            System.out.println("2. Read Warehouses");
            System.out.println("3. Update Warehouse");
            System.out.println("4. Delete Warehouse");
            System.out.println("0. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createWarehouse();
                    break;
                case 2:
                    readWarehouses();
                    break;
                case 3:
                    updateWarehouse();
                    break;
                case 4:
                    deleteWarehouse();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }

    private void deleteWarehouse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to:");
        System.out.println("1. Delete warehouse");
        System.out.println("2. Delete warehouse-user link");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                deleteWarehouseById();
                break;
            case 2:
                deleteWarehouseUser();
                break;
            default:
                System.out.println("Invalid choice. Returning to the menu.");
                break;
        }
    }

    private void updateWarehouse() {

    }

    private void readWarehouses() {
        // Lấy danh sách các kho hàng và tài khoản liên kết
        List<WarehouseAccountReponseeDTO> warehouseAccounts = accountWareHouseService.readWarehouses();
        // Lấy danh sách các kho hàng không có tài khoản liên kết
        List<WareHouse> warehouses = wareHouseService.getAllWarehousesisNotUser();

        // Kiểm tra danh sách kho hàng có liên kết tài khoản
        if (warehouseAccounts.isEmpty()) {
            System.out.println("No warehouses found.");
        } else {
            System.out.println("List of warehouses and associated accounts:");
            for (WarehouseAccountReponseeDTO dto : warehouseAccounts) {
                System.out.printf("Username: %s | Email: %s | Warehouse Name: %s | Warehouse ID: %s%n",
                        dto.getUsername(), dto.getEmail(), dto.getWarehouseName(), dto.getWarehouseId());
            }
        }

        // Kiểm tra danh sách kho hàng không có liên kết tài khoản
        if (warehouses.isEmpty()) {
            System.out.println("No warehouses without users found.");
        } else {
            System.out.println("List of warehouses without associated accounts:");
            for (WareHouse warehouse : warehouses) {
                System.out.printf("Warehouse Name: %s | Warehouse ID: %s%n",
                        warehouse.getWarehouseName(), warehouse.getWarehouseId());
            }
        }
    }

    private void createWarehouse() {
        System.out.print("Enter warehouse name: ");
        String name = sc.nextLine();
        WareHouse warehouse = new WareHouse(Random.generateRandomId(), name);
        wareHouseService.createWarehouse(warehouse);
        System.out.print("Do you want to create a User for this Warehouse? (yes/no): ");
        String response = sc.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            System.out.print("Enter user email: ");
            String email = sc.nextLine();
            System.out.print("Enter user password: ");
            String password = sc.nextLine();

            // Create user with the warehouse ID
            Account user = new Account(Random.generateRandomId(), Base64.getEncoder().encodeToString(password.getBytes()), email, 0);
            accountService.CreateAccount(user);
            AccountWarehouse accountWarehouse = new AccountWarehouse(user.getUsername(), warehouse.getWarehouseId());
            accountWareHouseService.createAccountWarehouse(accountWarehouse);
            System.out.println("User created and assigned to warehouse successfully.");
        } else {
            System.out.println("No user created for this warehouse.");
        }
        System.out.println("Warehouse created successfully.");
    }

    private void login() {
        System.out.println("------------- Login ----------------");
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        accountService.Login(email, password);

    }



    private void viewProducts() {
        System.out.println("Viewing products...");
        // Implement logic for viewing products
    }

    private void importProducts() throws IOException {
        System.out.println("Importing products as User...");
        ExcelHandingFile excelHandingFile = new ExcelHandingFile();
        excelHandingFile.readExcelFile("DanhSachSP1.xlsx");
        // Implement logic for importing products from Excel as User
    }

    private void deleteWarehouseById() {
        List<WareHouse> warehouses = wareHouseService.findAll();

        if (warehouses.isEmpty()) {
            System.out.println("No warehouses found.");
            return;
        }

        System.out.println("Select a warehouse to delete:");
        for (int i = 0; i < warehouses.size(); i++) {
            WareHouse warehouse = warehouses.get(i);
            System.out.printf("%d. Warehouse Name: %s | Warehouse ID: %s%n", i + 1, warehouse.getWarehouseName(), warehouse.getWarehouseId());
        }

        System.out.print("Enter the number of the warehouse to delete: ");
        int index = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (index > 0 && index <= warehouses.size()) {
            WareHouse selectedWarehouse = warehouses.get(index - 1);
            accountWareHouseService.deleteAccountWarehouseWithwarehouseId(selectedWarehouse.getWarehouseId());
            wareHouseService.deleteWarehouse(selectedWarehouse.getWarehouseId());
            System.out.println("Warehouse deleted successfully.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private void deleteWarehouseUser() {
        List<WarehouseAccountReponseeDTO> warehouseAccounts = accountWareHouseService.readWarehouses();

        if (warehouseAccounts.isEmpty()) {
            System.out.println("No warehouse-user found.");
            return;
        }

        System.out.println("Select a warehouse-user link to delete:");
        for (int i = 0; i < warehouseAccounts.size(); i++) {
            WarehouseAccountReponseeDTO dto = warehouseAccounts.get(i);
            System.out.printf("%d. Username: %s | Warehouse Name: %s | Warehouse ID: %s%n", i + 1, dto.getUsername(), dto.getWarehouseName(), dto.getWarehouseId());
        }

        System.out.print("Enter the number of the link to delete: ");
        int index = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (index > 0 && index <= warehouseAccounts.size()) {
            WarehouseAccountReponseeDTO selectedLink = warehouseAccounts.get(index - 1);
            accountWareHouseService.deleteAccountWarehouseWithaccountId(selectedLink.getUsername());
            accountWareHouseService.deleteAccountWarehouseWithwarehouseId(selectedLink.getWarehouseId());
            System.out.println("Warehouse-user deleted successfully.");
        } else {
            System.out.println("Invalid selection.");
        }

    }
}
