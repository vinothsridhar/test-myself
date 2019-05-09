package in.sri.test.thread;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<E> {

    private Queue<E> queue = new LinkedList<E>();

    private int max;

    private Object notFull = new Object();

    private Object notEmpty = new Object();

    public MyBlockingQueue(int max) {
        this.max = max;
    }

    public void put(E e) {
        while (queue.size() == max) {
            synchronized (notFull) {
                try {
                    notFull.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }  
        }
        
        queue.add(e);
        
        synchronized(notEmpty) {
            notEmpty.notifyAll();
        }
    }
    
    public E take() {
        while (queue.size() == 0) {
            synchronized(notEmpty) {
                try {
                    notEmpty.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        E item = queue.remove();

        synchronized(notFull) {
            notFull.notifyAll();
        }

        return item;
    }
}
