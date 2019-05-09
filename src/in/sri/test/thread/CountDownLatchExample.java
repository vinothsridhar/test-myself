package in.sri.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService es = Executors.newFixedThreadPool(4);
        
        es.submit(new Task(latch));
        
        Thread.sleep(3000);
        
        es.submit(new Task(latch));
        
        Thread.sleep(2000);
        
        es.submit(new Task(latch));
        
        latch.await();
        
        System.out.println("completed");
    }

    private static class Task implements Runnable {
        
        private CountDownLatch latch;
        
        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("counting down");
            latch.countDown();
        }
        
    }
    
}
