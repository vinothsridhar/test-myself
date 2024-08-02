import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable runningCommand = () -> System.out.println("Running command");
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runningCommand, 1, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            scheduledFuture.cancel(false);
            scheduledExecutorService.shutdown();
        }, 10, TimeUnit.SECONDS);
    }

}
