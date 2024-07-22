import DemoThread.MyThread1;
import DemoThread.MyThread2;

public class Main {
    private static Long getCurrentCPU(){
        return java.lang.management.ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }
    public static void main(String[] args) {
        System.out.println("Thread" + Thread.currentThread().getName()+"  is running on CPU core "+getCurrentCPU());
    }
}