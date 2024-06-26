package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MarketingStaff extends Staff{
    private BigDecimal sales;

    public MarketingStaff(String ID, String name, BigDecimal wage, BigDecimal sales) {
        super(ID, name, wage);
        this.sales = sales;
    }

    public MarketingStaff(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getBonus() {
        BigDecimal bonus;
            // compateTo so sanh sales voiw new BigDecimal (500tr) neu > => 1 ; = => 0 ; < => -1
        if (sales.compareTo(new BigDecimal("500000000")) >= 0) {
            // sales.multiply cho nhan 2 doi tuong voi nhau
            bonus = sales.multiply(new BigDecimal("0.05"));
        } else if (sales.compareTo(new BigDecimal("200000000")) >= 0) {
            bonus = sales.multiply(new BigDecimal("0.03"));
        } else if (sales.compareTo(new BigDecimal("100000000")) >= 0) {
            bonus = sales.multiply(new BigDecimal("0.02"));
        } else {
            bonus = sales.multiply(new BigDecimal("0.01"));
        }

        return bonus.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal ThuNhap(){
        BigDecimal TotalWage = super.getWage().add(getBonus().subtract(super.getThueThuNhap()));
        return  TotalWage.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void output(){
        System.out.printf("Tên: %10s | Mã Nhân Viên: %10s%n", super.getName(), super.getID());
        System.out.printf("Tiền Lương: %.2f%n", super.getWage());
        System.out.printf("Thuế Thu Nhập: %.2f%n", this.getThueThuNhap());
        System.out.printf("Tiền Thưởng: %.2f%n", this.getBonus());
        System.out.printf("Thu Nhập Sau Thuế: %.2f%n", this.ThuNhap());
    }
}
