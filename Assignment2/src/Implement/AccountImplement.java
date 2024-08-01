package Implement;

import DAO.AccountDAO;
import Entity.Account;
import Service.AccountService;
import Utils.Auth;
import Utils.Random;

import java.util.Base64;
import java.util.List;

public class AccountImplement implements AccountService {

    private AccountDAO accountDAO = new AccountDAO();

//    public AccountImplement() {
//        this.accountDAO = new AccountDAO();
//    }

    @Override
    public void CreateAdmin() {
        if(accountDAO.findByEmail("admin")==null){
            Account admin = new Account(Random.generateRandomId(),Base64.getEncoder().encodeToString("admin".getBytes()),"admin",1);
            accountDAO.save(admin);
        }
    }

    @Override
    public Account CreateAccount(Account account) {
       if(account!= null){
           if(accountDAO.findByEmail(account.getEmail())==null){
               accountDAO.save(account);
           }else{
               System.out.println("Account already exists");
           }
       }else {
           System.out.println("No account exists");
       }
        return account;
    }

    @Override
    public Account UpdateAccount(Account account) {
        accountDAO.update(account);
        return account;
    }

    @Override
    public void DeleteAccount(Account account) {
        accountDAO.delete(account.getUsername());
    }

    @Override
    public List<Account> GetAllAccounts() {
        return accountDAO.findAll();
    }

    @Override
    public Account GetAccountByEmail(String email) {
        return accountDAO.findByEmail(email);
    }

    @Override
    public void Login(String email, String password) {
        Account account = accountDAO.findByEmail(email);
        if(account!=null){
            // Giải mã mật khẩu được mã hóa trong cơ sở dữ liệu
            String decodedPassword = new String(Base64.getDecoder().decode(account.getPassword()));
            if(decodedPassword.equals(password)){
                Auth.user = account;
            }
        }else {
            System.out.println("Account Not Found");
        }
    }

    @Override
    public void Logout() {
        Auth.clear();
    }
}
