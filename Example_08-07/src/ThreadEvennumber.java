public class ThreadEvennumber extends Thread{
    @Override
   synchronized public void run() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println("Thread Even number :"+ i);
                try {
                   sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
