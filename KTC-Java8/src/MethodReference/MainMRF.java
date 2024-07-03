package MethodReference;

public class MainMRF {
    public static void main(String[] args) {
        //use Method Reference
        int x=5;
        int y=10;
       int z = todo(x,y,Service::tinhtong);
        System.out.println(z);
    }
    public static int todo(int x, int y, Calculator calculator  ) {
        return calculator.calculate(x,y);
    }
}
