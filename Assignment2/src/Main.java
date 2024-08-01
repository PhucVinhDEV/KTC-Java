import DAO.AccountDAO;
import Entity.Account;
import Implement.AccountImplement;
import Service.AccountService;
import Utils.Auth;
import Utils.Menu;
import Utils.Random;


import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountImplement();
        accountService.CreateAdmin();


        Menu menu = new Menu();
        menu.mainMenu();
    }
}