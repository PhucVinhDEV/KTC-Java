package Bai4;

public class XeMay extends Xeco{
    String model="Warrior200";
    double Efficiency=2.1;
    double DistanceTrabeled=4.41;
    double MaxSpeed=80.0;
    @Override
    public void Model() {
        System.out.println("Motorcycle model: " + this.model);
    }

    @Override
    public void Efficiency() {
        System.out.println("Fuel Efficiency: " + this.Efficiency +" mpg");
    }

    @Override
    public void DistanceTraveled() {
        System.out.println("Distance Traveled: " + this.DistanceTrabeled +" miles");
    }

    @Override
    public void Maxspeed() {
        System.out.println("Max Speed: " + this.MaxSpeed + " mqh");
    }
}
