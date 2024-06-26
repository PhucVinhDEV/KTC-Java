package Model;

import Service.AccountService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SavingAccount implements AccountService {
    Scanner sc = new Scanner(System.in);
    private String id;
    private String fullname;
    BigDecimal surplus;
    BigDecimal Interestrate ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public SavingAccount() {
    }

    public SavingAccount(String id, String fullname, BigDecimal surplus, BigDecimal interestrate) {
        this.id = id;
        this.fullname = fullname;
        this.surplus = surplus;
        Interestrate = interestrate;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public BigDecimal getInterestrate() {
        return Interestrate;
    }

    public void setInterestrate(BigDecimal interestrate) {
        Interestrate = interestrate;
    }




    @Override
    public void Depoisit(BigDecimal deposit) {
        if (deposit.compareTo(BigDecimal.ZERO) > 0) {
            this.surplus = this.surplus.add(deposit);
            System.out.println("Deposit successful! New surplus: " + this.surplus);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    @Override
    public void withdraw(BigDecimal withdraw) {

        if (withdraw.compareTo(this.getSurplus()) < 0) {
            this.surplus = this.surplus.subtract(withdraw);
            System.out.println("Withdrawal successful! New surplus: " + this.surplus);
        } else {
            System.out.println("Withdrawal amount exceeds available funds including overdraft limit.");
        }
    }




    public void CalculateInterestRate() {
        // set Surplus = surplus hiện tại + subplus hiện tại * getInterestrate/100;
        BigDecimal interest = surplus.multiply(Interestrate).divide(new BigDecimal("100"), RoundingMode.HALF_UP);

        this.setSurplus(surplus.add(interest));
        System.out.println("Lãi xuất sau 12 tháng");
        System.out.println("surplus: " + this.getSurplus());
    }
}
