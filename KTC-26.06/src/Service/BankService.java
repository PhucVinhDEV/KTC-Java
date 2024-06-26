package Service;

import Model.CurrentAccount;
import Model.SavingAccount;

import java.util.List;

public interface BankService {
    void AddCurrentAcount(List<CurrentAccount> currentAccounts);
    void RemoveCurrentAcount(List<CurrentAccount> currentAccounts);
    void updateCurrentAcount(List<CurrentAccount> currentAccounts);
    void ActionAccounCurrent(List<CurrentAccount> currentAccounts);

    void AddSavingAccount(List<SavingAccount> currentAccounts);
    void RemoveSavingAccount(List<SavingAccount> currentAccounts);
    void UpdateSavingAccount(List<SavingAccount> currentAccounts);
    void ActionSavingAccount(List<SavingAccount> currentAccounts);
}
