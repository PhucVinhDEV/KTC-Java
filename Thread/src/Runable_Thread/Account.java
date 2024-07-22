package Runable_Thread;

public class Account implements Runnable{
    private int balance = 2000;

    @Override
    public void run() {
        withdraw();
    }

    public void withdraw() {
        try {
            balance = balance - 1000;

            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);

            if(balance < 0) {
                System.out.println("Het tien");
            }else {
                System.out.println("Ok");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
