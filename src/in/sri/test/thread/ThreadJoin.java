package in.sri.test.thread;

public class ThreadJoin {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 running");
            try {
                Thread.sleep(1_1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 running");
        });

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

        System.out.println("main exiting");

    }

}
