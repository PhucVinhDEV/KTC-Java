package Bai3_2;

public class Programer extends Employee{
    public Programer(String name, String address) {
        super(name, address);
    }

    @Override
    public void displayBonus(double bonus) {
        System.out.println("Programer Bonus: " + bonus);
    }

    @Override
    public void displayPerformance(String performance) {
        System.out.println("Performance Report for Programer " + getName() + ": " + performance);
    }

    @Override
    public void displayJobDetails(String managerProject) {
        System.out.println("Programer " + getName() + " " + managerProject);
    }
}
