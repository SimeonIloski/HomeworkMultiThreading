import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start value of counter is 5");
        ReentrantLocking reentrantLocking=new ReentrantLocking(5);
        LockTester lockTester=new LockTester(reentrantLocking);
        LockTester lockTester1=new LockTester(reentrantLocking);
        LockTester lockTester2=new LockTester(reentrantLocking);
        lockTester.run();
        lockTester1.run();
        lockTester2.run();
    }
}


