import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NewThread extends Thread {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);
    static int n;
    static Person person;
    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    // Returns the current thread's unique ID, assigning it if necessary
    public int getThreadId() {
        return threadId.get();
    }

    // Returns the current thread's starting timestamp
    private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };


    @Override
    public void run() {
        //printing the date of creating of the thread
        System.out.println("Starting Thread: \t : \t"  + startDate.get());
        LocalThreadTest localThreadTest=new LocalThreadTest(threadId);
        localThreadTest.getTestResult();
        System.out.println("Thread Finished: \t : \t\n"  + startDate.get());
    }
}