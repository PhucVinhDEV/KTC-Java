import Bai1.Bicycle;
import Bai1.Car;
import Bai1.Vehicle;
import Bai2.HrManager;
import Bai2.NhanVien;
import Bai3_2.Development;
import Bai3_2.Employee;
import Bai3_2.Manager;
import Bai3_2.Programer;
import Bai4.Oto;
import Bai4.XeMay;
import Bai4.Xeco;
import Bai4.Xetai;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bài 1");

        System.out.println("Vehicle:");
        Vehicle vehicle = new Vehicle();
        System.out.println("vehicle Speedup: " + vehicle.speedUp());



        System.out.println("Bicycle:");
        Bicycle bicycle = new Bicycle();
        System.out.println("bicycle Speedup: " + bicycle.speedUp());


        System.out.println("car:");
        Car car = new Car();
        System.out.println("Car Speedup: " + car.speedUp());
        System.out.println();
        System.out.println("-------------------------------------------------------------");

        System.out.println("Bài 2");

        NhanVien nv = new NhanVien();
        nv.work();
        nv.getsalary();
        System.out.println();

        HrManager hrManager = new HrManager();
        hrManager.work();
        hrManager.getsalary();
        System.out.println();
        hrManager.addEmployee();



        System.out.println("-------------------------------------------------------------");

        System.out.println("Bài 3_2");

        Employee developer = new Development("Iver Dapali","Cần Thơ");
        Employee progamer = new Programer("Yaron Gabriel","Cần Thơ");
        Employee manager = new Manager("Avril Aroldo","Cần Thơ");

        manager.displayBonus(12000);
        developer.displayBonus(7200);
        progamer.displayBonus(9120);

        manager.displayPerformance("Excellent");
        developer.displayPerformance("good");
        progamer.displayPerformance("Excellent");

        progamer.displayJobDetails("is managing a project");
        developer.displayJobDetails("writing  a Java code");
        progamer.displayJobDetails("is debuging code in python");


        System.out.println("---------------------------------------------");
        System.out.println("Bài 4");

        Xeco xemay = new XeMay();
        xemay.Model();
        xemay.Efficiency();
        xemay.DistanceTraveled();
        xemay.Maxspeed();
        System.out.println();

        Xeco oto = new Oto();
        oto.Model();
        oto.Efficiency();
        oto.DistanceTraveled();
        oto.Maxspeed();
        System.out.println();

        Xeco xetai = new Xetai();
        xetai.Model();
        xetai.Efficiency();
        xetai.DistanceTraveled();
        xetai.Maxspeed();
    }
}