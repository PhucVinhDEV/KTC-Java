public class Timer implements Runnable {
    private boolean running = true;

    public void stop() {
        running = false;
    }
    @Override
    public void run() {
        int seconds = 0;
        while (running) {
            try {
                Thread.sleep(1000); // Ngủ 1 giây
                seconds++;
                System.out.println("Thời gian trôi qua: " + seconds + " giây");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Timer timerTask = new Timer();
        Thread timerThread = new Thread(timerTask);
        timerThread.start();

        // Chương trình chính sẽ chờ 10 giây trước khi dừng đồng hồ
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Dừng đồng hồ
        timerTask.stop();
        System.out.println("Chương trình kết thúc.");
    }
}
