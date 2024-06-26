package Model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Staff {
    private String ID;
    private String Name;
    private BigDecimal wage;

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public Staff() {
    }

    public Staff(String ID, String name, BigDecimal wage) {
        this.ID = ID;
        Name = name;
        this.wage = wage;
    }
    public BigDecimal ThuNhap(){
        //Subtract = -
        return this.wage.subtract(getThueThuNhap());
    }

    public BigDecimal getThueThuNhap(){
//        if(this.wage<9000000)
//            return 0;
//        else if(this.wage<15000000)
//            return this.wage*0.1;
//        else
//            return this.wage*0.12;
        if(this.wage.compareTo(new BigDecimal(9000000)) == -1){
            return BigDecimal.ZERO;
        } else if (this.wage.compareTo(new BigDecimal(15000000)) == -1) {
            return this.wage.multiply(new BigDecimal(0.1));
        } else {
            return this.wage.multiply(new BigDecimal(0.12));
        }

    }

    public void output(){
        System.out.printf(" Tên:%10s | Mã Nhân Viên:%10s | Tiền Lương:%.2f ",this.Name,this.ID ,this.wage);
        System.out.println(" \t Thuế Thu Nhập là:"+this.getThueThuNhap());
        System.out.println("Thu Nhập :"+this.ThuNhap());
    }
}
