package DemoThread;

public class MainThread {  public static void main(String[] args) {
    MyThread1 my1 = new MyThread1();
    Thread t1 = new Thread(my1);

    MyThread2 my2 = new MyThread2();


    t1.start();
    my2.start();
    }
}
