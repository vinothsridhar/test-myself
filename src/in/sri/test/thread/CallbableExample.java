package in.sri.test.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CallbableExample {

    private static ExecutorService es = Executors.newFixedThreadPool(2);
    

    Semaphore semaphore = new Semaphore(10);
    
    public static void main(String[] args) {
        
        Future<Integer> f = es.submit(new Task());
        
        System.out.println("Task submitted");
        
        try {
            Integer value = f.get();
            System.out.println("fetched value: " + value);
            es.shutdown();
            es.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
    
    private static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
        
    }
}
