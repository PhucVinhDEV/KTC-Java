package org.example;

import org.example.Implement.AccountImplement;
import org.example.Service.AccountService;
import org.example.Utils.ExcelHandingFile;
import org.example.Utils.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountService accountService = new AccountImplement();
        accountService.CreateAdmin();

        Menu menu = new Menu();
        menu.mainMenu();

    }
}