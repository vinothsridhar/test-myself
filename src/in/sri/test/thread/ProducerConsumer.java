package in.sri.test.thread;

public class ProducerConsumer {

    private static int count = 0;

    public static void main(String[] args) {

        MyBlockingQueue<Item> queue = new MyBlockingQueue<Item>(10);

        final Runnable producer = () -> {
            while (true) {
                Item item = new Item();
                item.setName(String.valueOf(count++));
                System.out.println("producing value: " + item.getName());
                queue.put(item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            while(true) {
                Item item = queue.take();
                System.err.println("consuming value: " + item.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}