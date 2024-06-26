package Model;

import java.math.BigDecimal;

public class Manager extends Staff{
    private BigDecimal TrachNhiem;

    public BigDecimal getTrachNhiem() {
        return TrachNhiem;
    }

    public void setTrachNhiem(BigDecimal trachNhiem) {
        TrachNhiem = trachNhiem;
    }

    public Manager(String ID, String name, BigDecimal wage, BigDecimal trachNhiem) {
        super(ID, name, wage);
        TrachNhiem = trachNhiem;
    }

    public Manager(BigDecimal trachNhiem) {
        TrachNhiem = trachNhiem;
    }

    @Override
    public BigDecimal ThuNhap() {
        BigDecimal wage = super.getWage();
        BigDecimal thueThuNhap = super.getThueThuNhap();
        BigDecimal trachNhiem = this.TrachNhiem; // Lấy giá trị trách nhiệm từ trường của Manager

        // Tính toán thu nhập của Manager
        BigDecimal thuNhap = wage.add(trachNhiem).subtract(thueThuNhap);

        return thuNhap.setScale(2 , BigDecimal.ROUND_HALF_UP);
    }


    @Override
    public void output(){
        super.output();
        System.out.println("\t Trách Nhiêm :" +this.TrachNhiem);
    }
}
