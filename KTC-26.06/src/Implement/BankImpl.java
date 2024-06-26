package Implement;

import Model.CurrentAccount;
import Model.SavingAccount;
import Service.BankService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BankImpl implements BankService {
    Scanner sc = new Scanner(System.in);


    @Override
    public void AddCurrentAcount(List<CurrentAccount> listcurrentAccounts) {
        System.out.println("Current account added");
        System.out.println("ID CurrentAccount :");
        String id = sc.nextLine();
        System.out.println("Name :");
        String name = sc.nextLine();
        System.out.println("Initial Deposit: $"  );
        BigDecimal surplus = sc.nextBigDecimal();
        System.out.println("OverdraftLimit: $");
        BigDecimal overdraftLimit = sc.nextBigDecimal();
        CurrentAccount currentAccount = new CurrentAccount(name,surplus,overdraftLimit,id);
        listcurrentAccounts.add(currentAccount);
        System.out.println("Current account added successfully");
    }



    @Override
    public void RemoveCurrentAcount(List<CurrentAccount> currentAccounts) {
        System.out.println("Current account delete");
        System.out.println("ID CurrentAccount :");
        String id = sc.nextLine();
        boolean removed = false;
        for (int i = 0; i < currentAccounts.size(); i++) {
            if (currentAccounts.get(i).getId().equals(id)) {
                currentAccounts.remove(i);
                removed = true;
                System.out.println("Current account removed successfully");
                break;
            }
        }

        if (!removed) {
            System.out.println("Current account not found");
        }
    }

    @Override
    public void updateCurrentAcount(List<CurrentAccount> currentAccounts) {
        System.out.println("Updating Current Account");
        System.out.print("Enter ID of account to update: ");
        String id = sc.nextLine();
        sc.nextLine();

        boolean found = false;
        for (CurrentAccount account : currentAccounts) {
            if (account.getId().equals(id)) {
                System.out.print("New Name: ");
                String newName = sc.nextLine();
                System.out.print("New Initial Deposit: $");
                BigDecimal newSurplus = sc.nextBigDecimal();
                System.out.print("New Overdraft Limit: $");
                BigDecimal newOverdraftLimit = sc.nextBigDecimal();

                account.setFullname(newName);
                account.setSurplus(newSurplus);
                account.setOverdraftLimit(newOverdraftLimit);

                System.out.println("Current account updated successfully");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Current account not found");
        }
    }

    @Override
    public void ActionAccounCurrent(List<CurrentAccount> listcurrentAccounts) {
        System.out.printf("%-5s %-5s %-20s %-10s\n","Index", "ID", "Tên Họ Tên" , "Số dư");
        if (!listcurrentAccounts.isEmpty()) {
            for (CurrentAccount s : listcurrentAccounts) {
                System.out.printf("%-5s %-5s %-20s %-10f\n",listcurrentAccounts.indexOf(s), s.getId(), s.getFullname(), s.getSurplus());
            }
            System.out.println("Nhập tài khoản bạn muốn chọn");
            int choice = sc.nextInt();
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rut Tiền");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    System.out.println("Nhập số tiền bạn muốn gửi");

                    BigDecimal Depoisit = sc.nextBigDecimal();
                    listcurrentAccounts.get(choice).Depoisit(Depoisit);
                case 2:
                    System.out.println("Nhập số tiền bạn muốn rút:");
                    System.out.println("Số tiền phải < " + listcurrentAccounts.get(choice).getOverdraftLimit());
                    BigDecimal Rut = sc.nextBigDecimal();
                    listcurrentAccounts.get(choice).withdraw(Rut);
                case 3:
                    return;
            }
        }else {
            System.out.println("Account current is not found");
        }
    }

    @Override
    public void AddSavingAccount(List<SavingAccount> listSavingAccounts) {
        System.out.println("Saving account added");
        System.out.println("ID SavingAccount :");
        String id = sc.nextLine();
        System.out.println("Name :");
        String name = sc.nextLine();
        System.out.println("Initial Deposit: $"  );
        BigDecimal surplus = sc.nextBigDecimal();
        System.out.println("Interestrate: $");
        BigDecimal interstrate = sc.nextBigDecimal();
        SavingAccount savingAccount = new SavingAccount(id,name,surplus,interstrate);
        listSavingAccounts.add(savingAccount);
        System.out.println("Current account added successfully");
    }


    @Override
    public void RemoveSavingAccount(List<SavingAccount> listSavingAccounts) {
        System.out.println("Removing Saving Account");
        System.out.print("Enter ID of account to remove: ");
        String id = sc.nextLine();

        boolean removed = false;
        for (int i = 0; i < listSavingAccounts.size(); i++) {
            if (listSavingAccounts.get(i).getId().equals(id)) {
                listSavingAccounts.remove(i);
                removed = true;
                System.out.println("Saving account removed successfully");
                break;
            }
        }

        if (!removed) {
            System.out.println("Saving account not found");
        }
    }

    @Override
    public void UpdateSavingAccount(List<SavingAccount> listSavingAccounts) {
        System.out.println("Updating Saving Account");
        System.out.print("Enter ID of account to update: ");
        String id = sc.nextLine();

        boolean found = false;
        for (SavingAccount account : listSavingAccounts) {
            if (account.getId().equals(id)) {
                System.out.print("New Name: ");
                String newName = sc.nextLine();
                System.out.print("New Initial Deposit: $");
                BigDecimal newInitialDeposit = sc.nextBigDecimal();
                sc.nextLine(); // Consume newline left by nextBigDecimal()

                account.setFullname(newName);
                account.setSurplus(newInitialDeposit);

                System.out.println("Lưu tài khoản thành cong!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Saving account not found");
        }
    }

    @Override
    public void ActionSavingAccount(List<SavingAccount> listSavingAccounts) {
        System.out.printf("%-5s %-5s %-20s %-10s\n","Index", "ID", "Tên Họ Tên" , "Số dư");
        if (!listSavingAccounts.isEmpty()) {
            for (SavingAccount s : listSavingAccounts) {
                System.out.printf("%-5s %-5s %-20s %-10f\n",listSavingAccounts.indexOf(s), s.getId(), s.getFullname(), s.getSurplus());
                s.CalculateInterestRate();
            }
            System.out.println("Nhập ID tài khoản bạn muốn chọn");
            int choice = sc.nextInt();
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rut Tiền");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    System.out.println("Nhập số tiền bạn muốn gửi");
                    BigDecimal Depoisit = sc.nextBigDecimal();
                    listSavingAccounts.get(choice).Depoisit(Depoisit);
                    break;
                case 2:
                    System.out.println("Nhập số tiền bạn muốn rút:");
                    BigDecimal Rut = sc.nextBigDecimal();
                    listSavingAccounts.get(choice).withdraw(Rut);
                    break;
                case 3:
                    return;
            }
        }else {
            System.out.println("Account current is not found");
        }
    }

}
