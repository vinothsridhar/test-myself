## ReadWrite Lock
```
class UserCache {
    private final Map<String, User> cache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public User get(String id) {
        //Allow multiple reads
        //Block all the reads during write inprogress
        lock.readLock().lock();
        try {
            return cache.get(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(String id, User user) {
        //Allow only one write
        //Block all the reads and writes during write inprogress
        lock.writeLock().lock();
        try {
            cache.put(id, user);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
```

## Reentrant Lock
```
import java.util.concurrent.locks.ReentrantLock;

public class SharedLockExample {
    // Single shared lock object
    private final ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock(); // Thread 1 acquires lock
        try {
            System.out.println("HelloA");
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock(); // Thread 2 must WAIT here if Thread 1 holds the lock
        try {
            System.out.println("Hello");
        } finally {
            lock.unlock();
        }
    }
}


import java.util.concurrent.locks.ReentrantLock;

public class SolvedLockExample {
    // Two separate locks
    private final ReentrantLock lockA = new ReentrantLock();
    private final ReentrantLock lockB = new ReentrantLock();

    public void methodA() {
        lockA.lock(); // Thread 1 acquires lockA
        try {
            System.out.println("HelloA");
        } finally {
            lockA.unlock();
        }
    }

    public void methodB() {
        lockB.lock(); // Thread 2 acquires lockB instantly (No waiting!)
        try {
            System.out.println("Hello");
        } finally {
            lockB.unlock();
        }
    }
}

```

