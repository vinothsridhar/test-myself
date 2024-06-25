package in.sri.test.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbableExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Task submitted");

        try (ExecutorService es = Executors.newFixedThreadPool(2)) {
            Future<Integer> f = es.submit(new Task());
            Integer value = f.get();
            System.out.println("fetched value: " + value);
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
