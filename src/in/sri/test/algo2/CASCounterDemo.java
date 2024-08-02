import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASCounterDemo {

    public static void main(String[] args) {

        NonBlockingCounter counter = new NonBlockingCounter();

        Runnable r = () -> {
            for (int i = 0; i < 1_00_000; i++) {
                counter.nonSyncInc();
            }
        };

        try (ExecutorService es = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 5; i++) {
                es.submit(r);
            }
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());

    }

    static class NonBlockingCounter {

        private final AtomicInteger counter = new AtomicInteger(0);

        public void nonSyncInc() {
            counter.incrementAndGet();
        }

        public void inc() {
            int value;
            int newValue;
            do {
                value = counter.get();
                newValue = value + 1;
            } while (!(counter.compareAndSet(value, newValue)));
        }

        public int getCount() {
            return counter.get();
        }

    }

}
