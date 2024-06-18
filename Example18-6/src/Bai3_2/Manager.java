package Bai3_2;

public class Manager extends Employee {
    public Manager(String name, String address) {
        super(name, address);
    }

    @Override
    public void displayBonus(double bonus) {
        System.out.println("Manager Bonus: " + bonus);
    }

    @Override
    public void displayPerformance(String performance) {
        System.out.println("Performance Report for Manager " + getName() + ": " + performance);
    }

    @Override
    public void displayJobDetails(String managerProject) {
        System.out.println("Manager " + getName() + " " + managerProject);
    }
}
