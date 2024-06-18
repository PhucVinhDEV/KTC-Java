package Bai3_2;

public abstract class Employee {
    private String name;
    private String adress;
    private double salary;
    private String Jobtitle;

    public Employee(String name, String address) {
    }

    public abstract void displayBonus(double bonus);
    public abstract void displayPerformance(String performance);
    public abstract void displayJobDetails(String managerProject);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }
}
