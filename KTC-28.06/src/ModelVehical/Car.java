package ModelVehical;

public class Car extends Vehicle{
    int NumberOfDoors;

    protected Car(int id) {
        super(id);
    }

    public Car(int id, int numberOfDoors) {
        super(id);
        NumberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return NumberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        NumberOfDoors = numberOfDoors;
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
