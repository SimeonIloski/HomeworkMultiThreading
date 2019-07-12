import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {
    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);
    /**
     * METHOD WHICH NEEDS TO BE LOCKED TO STOP concurrently INCREASING COUNTER
     * **/
    public void incrementCounter() {
        reLock.lock();
        try {
            System.out.println("Counter is locked");
            counter += 1;
        } finally {
            System.out.println("Counter is unlocked");
            reLock.unlock();
        }
    }

    public ReentrantLocking(int counter) {
        this.counter = counter;
    }

    public ReentrantLocking() {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ReentrantLock getReLock() {
        return reLock;
    }
}
