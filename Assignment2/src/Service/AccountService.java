package Service;

import Entity.Account;
import Utils.Auth;

import java.util.List;

public interface AccountService {

    void CreateAdmin();
    void Login(String Email, String password);
    void Logout();


    Account CreateAccount(Account account);
    Account UpdateAccount(Account account);
    void DeleteAccount(Account account);
    List<Account> GetAllAccounts();
    Account GetAccountByEmail(String email);
}
