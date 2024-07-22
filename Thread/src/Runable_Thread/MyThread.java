package Runable_Thread;

public class MyThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(super.getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        //set thuoc tinh thread
        t1.setName("T1");
        t2.setName("T2");

        //Chay thread
        t1.start();
        t2.start();
    }
}
