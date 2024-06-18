package Bai3_2;

public class Development  extends Employee {

    public Development(String name, String address) {
        super(name, address);
    }

    @Override
    public void displayBonus(double bonus) {
        System.out.println("Developer Bonus: " + bonus);
    }

    @Override
    public void displayPerformance(String performance) {
        System.out.println("Performance Report for Developer " + getName() + ": " + performance);
    }

    @Override
    public void displayJobDetails(String managerProject) {
        System.out.println("Developer " + getName() + " " + managerProject);
    }
}
