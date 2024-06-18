package Bai4;

public class Oto extends Xeco {
    String model="Virtus";
    double Efficiency=2.355;
    double DistanceTrabeled=14.419665;
    double MaxSpeed=120.0;
    @Override
    public void Model() {
        System.out.println("Car model: " + this.model);
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
