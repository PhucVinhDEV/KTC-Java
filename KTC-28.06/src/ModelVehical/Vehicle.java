package ModelVehical;

public abstract class Vehicle {
    private String name;
    final int id;
    public abstract void move();
    public static int vahicleCount;
    protected Vehicle(int id) {
        this.id = id;
        vahicleCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
}
