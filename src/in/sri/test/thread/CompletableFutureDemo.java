package in.sri.test.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();

        CompletableFuture<String> fetchUserPage = CompletableFuture.supplyAsync(new FetchUserDetails());

        // all of

        CompletableFuture<String> fetchOrderPage = CompletableFuture.supplyAsync(new FetchOrderDetails());
        CompletableFuture<Void> allOf = CompletableFuture.allOf(fetchUserPage, fetchOrderPage);

        allOf.get();

        String combinedPage = Stream.of(fetchUserPage, fetchOrderPage)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(","));
        System.out.println(combinedPage);

        long completeTime = System.currentTimeMillis();
        System.out.println("time taken: " + (completeTime - startTime));

        List<String> list = new Vector<>();
    }

}

class FetchOrderDetails implements Supplier<String> {

    @Override
    public String get() {
        System.out.println("fetching order details");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "order_details";
    }

}

class FetchUserDetails implements Supplier<String> {

    @Override
    public String get() {
        System.out.println("fetching user details");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user_details";
    }

}