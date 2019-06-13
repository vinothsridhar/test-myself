package in.sri.test.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    
    private static int i = 0;
    
    private static ReentrantLock lock = new ReentrantLock();
    
    private static void resource() {
        lock.lock();
        System.out.println("before i = " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        System.out.println("after i = " + i);
        lock.unlock();
    }
    
    public static void main(String[] args) {
        
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        new Thread(() -> resource()).start();
        
    }

}
