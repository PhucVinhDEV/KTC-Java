package Model;

import java.util.List;

public class Bank {
    List<CurrentAccount> currentAccount;
    List<SavingAccount> savingAccount;

    public List<CurrentAccount> getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(List<CurrentAccount> currentAccount) {
        this.currentAccount = currentAccount;
    }

    public List<SavingAccount> getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(List<SavingAccount> savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Bank() {
    }

    public Bank(List<CurrentAccount> currentAccount, List<SavingAccount> savingAccount) {
        this.currentAccount = currentAccount;
        this.savingAccount = savingAccount;
    }
}
