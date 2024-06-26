import Implement.BankImpl;
import Model.Bank;
import Model.CurrentAccount;
import Model.SavingAccount;
import Service.AccountService;
import Service.BankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Bank bank = new Bank();
    Scanner sc = new Scanner(System.in);
    List<SavingAccount> savingAccounts = new ArrayList<>();
    List<CurrentAccount> currentAccounts = new ArrayList<>();
    BankService banservice = new BankImpl();
    public void Menu(){
        int choice;
        bank.setCurrentAccount(currentAccounts);
        bank.setSavingAccount(savingAccounts);



        AccountService accountCurrenService = new CurrentAccount();
        AccountService accountSavingService = new SavingAccount();
        do {
            System.out.println("\t\t Menu :");
            System.out.println("1. In ra danh sách công ty");
            System.out.println("2. Current Account :");
            System.out.println("3. SavingAccount   :");
            System.out.println("4. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            while (choice < 1 || choice > 4) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }

            switch (choice) {
                case 1:
                    System.out.println("Chức năng lười làm");
                    System.out.println("Nhấn Enter để tiếp tục chương trình");
                    sc.nextLine();
                    break;
                case 2:
                    MenuAccountCurrent();
                    break;
                case 3:
                    menuSavingAccount();
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    break;
            }
        } while (choice != 4);
    }

    public void MenuAccountCurrent() {
        int choice;
        do {
            System.out.println("\t\t Menu account current:");
            System.out.println("1. Thêm account current");
            System.out.println("2. Sửa account current");
            System.out.println("3. Xóa account current");
            System.out.println("4. Action account current");
            System.out.println("6. Trở lại");
            System.out.println("Mời bạn chọn chức năng:");
            choice = sc.nextInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }
            switch (choice) {
                case 1:
                    banservice.AddCurrentAcount(bank.getCurrentAccount());
                    waitForEnter();
                    break;
                case 2:
                    banservice.updateCurrentAcount(bank.getCurrentAccount());
                    waitForEnter();
                    break;
                case 3:
                    banservice.RemoveCurrentAcount(bank.getCurrentAccount());
                    waitForEnter();
                    break;
                case 4:
                    // Perform actions on current accounts
                    banservice.ActionAccounCurrent(bank.getCurrentAccount());
                    System.out.println("Performing action on current accounts...");
                    waitForEnter();
                    break;

                case 5:
                    return; // Return to previous menu
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (choice != 0);
    }

    public void menuSavingAccount() {
        int choice;
        do {
            System.out.println("\t\t Menu quản lý saving account:");
            System.out.println("1. Thêm saving account");
            System.out.println("2. Sửa saving account");
            System.out.println("3. Xóa saving account");
            System.out.println("4. Action saving account");
            System.out.println("5. Trở lại");
            System.out.println("Mời bạn chọn chức năng:");
            choice = sc.nextInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                System.out.print("Mời bạn chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            }
            switch (choice) {
                case 1:
                    banservice.AddSavingAccount(bank.getSavingAccount());
                    waitForEnter();
                    break;
                case 2:
                    banservice.UpdateSavingAccount(bank.getSavingAccount());
                    waitForEnter();
                    break;
                case 3:
                    banservice.RemoveSavingAccount(bank.getSavingAccount());
                    waitForEnter();
                    break;
                case 4:
                    // Perform actions on saving accounts
                    banservice.ActionSavingAccount(bank.getSavingAccount());
                    System.out.println("Performing action on saving accounts...");
                    waitForEnter();
                    break;
                case 5:
                    return; // Return to previous menu
                default:
                    System.out.println("\t Hãy chọn các chức năng trên:");
            }
        } while (choice != 0);
    }
    private void waitForEnter() {
        sc.nextLine(); // Consume newline left by nextInt()
        System.out.println("Enter để tiếp tục chương trình");
        sc.nextLine();
    }
    public static void main(String[] args) {
    Main main = new Main();
    main.Menu();
    }
}