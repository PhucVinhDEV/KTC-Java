package Model;

import Service.AccountService;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrentAccount implements AccountService {
    Scanner sc = new Scanner(System.in);
    private String id;
    private String fullname;
    BigDecimal surplus;
    BigDecimal OverdraftLimit ;

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public BigDecimal getOverdraftLimit() {
        return OverdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        OverdraftLimit = overdraftLimit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public CurrentAccount() {
    }

    public CurrentAccount(String fullname, BigDecimal surplus, BigDecimal overdraftLimit, String id) {
        this.fullname = fullname;
        this.surplus = surplus;
        OverdraftLimit = overdraftLimit;
        this.id = id;
    }


//    public void input() {
//
//        System.out.println("Current Account:");
//        System.out.println("Initial Deposit: $"  );
//        this.setSurplus(sc.nextBigDecimal());
//        System.out.println("OverdraftLimit: $");
//        this.setOverdraftLimit(sc.nextBigDecimal());
//
//        return ;
//    }

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

        if (withdraw.compareTo(this.OverdraftLimit) <= 0 && withdraw.compareTo(this.getSurplus()) < 0) {
            this.surplus = this.surplus.subtract(withdraw);
            System.out.println("Withdrawal successful! New surplus: " + this.surplus);
        } else {
            System.out.println("Withdrawal amount exceeds available funds including overdraft limit.");
        }
    }



}
