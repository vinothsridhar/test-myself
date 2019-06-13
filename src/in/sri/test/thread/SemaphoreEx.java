package in.sri.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreEx {
    
    public static void main(String[] args) {
        
        Semaphore semaphore = new Semaphore(3);
        
        ExecutorService es = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 20; i++) {
            es.submit(new Task(semaphore));
        }
        
        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            es.shutdownNow();
        }
        
    }

    private static class Task implements Runnable {
        
        private Semaphore semaphore;
        
        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            
            try {
                semaphore.acquire();
                System.out.println("--- acquired lock ---");
            } catch (InterruptedException e) {
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
            
            semaphore.release();
            
            System.err.println("released lock");
            
        }
        
    }
    
}
