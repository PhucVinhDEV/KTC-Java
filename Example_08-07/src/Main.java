public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ThreadEvennumber t1 = new ThreadEvennumber();
        ThreadOddnumber t2 = new ThreadOddnumber();

        t1.start();
        try {
            Thread.sleep(50); // Tạm dừng 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}