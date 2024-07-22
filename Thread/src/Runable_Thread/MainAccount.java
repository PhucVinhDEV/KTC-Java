package Runable_Thread;

public class MainAccount {
    public static void main(String[] args) {

        Account acc = new Account();

        Thread t1 = new Thread(acc);
        Thread t2 = new Thread(acc);
        Thread t3 = new Thread(acc);

        t1.start();
        t2.start();
        t3.start();
    }
}
