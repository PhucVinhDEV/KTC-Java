package org.example.Service;


import org.example.Entity.Account;

import java.util.List;

public interface AccountService {

    void CreateAdmin();
    void Login(String Email, String password);
    void Logout();

    /**
     *
     * @param account
     * @return
     */
    Account CreateAccount(Account account);
    Account UpdateAccount(Account account);
    void DeleteAccount(Account account);
    List<Account> GetAllAccounts();
    Account GetAccountByEmail(String email);
}
