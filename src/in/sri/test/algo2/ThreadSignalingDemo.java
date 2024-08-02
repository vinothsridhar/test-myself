import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class ThreadSignalingDemo {

    public static void main(String[] args) {

        SignalCarrier carrier = new SignalCarrier();

        Thread t1 = new Thread(() -> {
            try {
                carrier.doWait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(carrier::doNotify);

        t2.start();
        t1.start();
    }

    static class SignalCarrier {

        synchronized void doWait() throws InterruptedException {
            System.out.println("calling wait");
            this.wait();
            System.out.println("existing wait");
        }

        synchronized void doNotify() {
            System.out.println("calling notify");
            this.notify();
            System.out.println("existing notify");
        }

    }

}
