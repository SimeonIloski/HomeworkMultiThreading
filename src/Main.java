import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws IOException {
        //call of test method for  threads with ReentrantLock
        ReentrantLockTest();
       //call of test method for threads with ReentrantReadWriteLock
        reentrantreadWriteLockTest();


    }

    private static void ReentrantLockTest(){
        System.out.println("Start value of counter is 5");
        ReentrantLocking reentrantLocking=new ReentrantLocking(5);
        //call of three threads and run them at same time
        LockTester lockTester=new LockTester(reentrantLocking);
        LockTester lockTester1=new LockTester(reentrantLocking);
        LockTester lockTester2=new LockTester(reentrantLocking);
        lockTester.run();
        lockTester1.run();
        lockTester2.run();
    }
    public static  void reentrantreadWriteLockTest(){
        System.out.println("ReentrantReadWriteLockExample");
        ReadWriteLockThread readWriteLockThread=new ReadWriteLockThread(0);
        ReadWriteLockThread readWriteLockThread1=new ReadWriteLockThread(0);
        ReadWriteLockThread readWriteLockThread2=new ReadWriteLockThread(0);
        readWriteLockThread.run();
        readWriteLockThread1.run();
        readWriteLockThread2.run();
    }

}


