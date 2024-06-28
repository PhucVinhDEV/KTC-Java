import ModelVehical.Bike;
import ModelVehical.Car;
import ModelVehical.Vehicle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VehicleDemo {

    // Hàm tạo ID xe ngẫu nhiên
    private static int generateUniqueId(Random random, Set<Integer> uniqueIds) {
        int id;
        do {
            id = random.nextInt(100000);
        } while (uniqueIds.contains(id));
        uniqueIds.add(id);
        return id;
    }
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> uniqueIds = new HashSet<>();
        int id;

        Vehicle[] vehicles = new Vehicle[10];

        id = generateUniqueId(random, uniqueIds);
        Vehicle car = new Car(id,4);

        id = generateUniqueId(random, uniqueIds);
        Vehicle car1 = new Car(id,4);

        id = generateUniqueId(random, uniqueIds);
        Vehicle car2 = new Car(id,4);

        id = generateUniqueId(random, uniqueIds);
        Vehicle bike = new Bike(id,true);

        id = generateUniqueId(random, uniqueIds);
        Vehicle bike1 = new Bike(id,true);

        id = generateUniqueId(random, uniqueIds);
        Vehicle bike2 = new Bike(id,true);

        vehicles[0] = car;
        vehicles[1] = car1;
        vehicles[2] = car2;
        vehicles[3] = bike;
        vehicles[4] = bike1;
        vehicles[5] = bike2;


        for (int i = 0; i <= 5; i++) {

            System.out.println(vehicles[i].getId());
            vehicles[i].move();
        }

        System.out.println(Vehicle.vahicleCount);

    }
}
