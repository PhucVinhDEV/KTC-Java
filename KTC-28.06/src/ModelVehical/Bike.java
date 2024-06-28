package ModelVehical;

public class Bike extends Vehicle {
    boolean hasGear;

    protected Bike(int id) {
        super(id);
    }

    public Bike(int id, boolean hasGear) {
        super(id);
        this.hasGear = hasGear;
    }

    public boolean isHasGear() {
        return hasGear;
    }

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    @Override
    public void move() {
        System.out.println("Bike is moving!");
    }
}
