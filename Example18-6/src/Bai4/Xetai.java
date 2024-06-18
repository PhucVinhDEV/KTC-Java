package Bai4;

public class Xetai extends Oto{
    String model="Tatra 810 4x4";
    double Efficiency=8.075659532105526;
    double DistanceTrabeled=65.50975012444003;
    double MaxSpeed=80.0;
    @Override
    public void Model() {
        System.out.println("Struck model: " + this.model);
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
