import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws IOException {
        //call of test method for  threads with ReentrantLock
        ReentrantLockTest();
        //call of test method for threads with ReentrantReadWriteLock
        reentrantreadWriteLockTest();
        //call of test method for synchronized block with thread local, primitive types and custom objects
        threadLocalExampleTest();

    }

    private static void ReentrantLockTest(){
        System.out.println("Start value of counter is 5");
        ReentrantLocking reentrantLocking=new ReentrantLocking(5);
        //call of three threads and run them at same time
        LockTester lockTester=new LockTester(reentrantLocking);
        LockTester lockTester1=new LockTester(reentrantLocking);
        LockTester lockTester2=new LockTester(reentrantLocking);
        lockTester.start();
        lockTester1.start();
        lockTester2.start();
        lockTester.run();
        lockTester1.run();
        lockTester2.run();
        try{
            lockTester.join();
            lockTester1.join();
            lockTester2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private static  void reentrantreadWriteLockTest(){
        File file =new File("test.txt");
        System.out.println("ReentrantReadWriteLockExample");
        ReadWriteLockThread readWriteLockThread=new ReadWriteLockThread(0,file);
        ReadWriteLockThread readWriteLockThread1=new ReadWriteLockThread(0,file);
        ReadWriteLockThread readWriteLockThread2=new ReadWriteLockThread(0,file);
        readWriteLockThread.start();
        readWriteLockThread1.start();
        readWriteLockThread2.start();
        readWriteLockThread.run();
        readWriteLockThread1.run();
        readWriteLockThread2.run();
        try{
            readWriteLockThread.join();
            readWriteLockThread1.join();
            readWriteLockThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void threadLocalExampleTest(){
        System.out.println("Example for synchronized block with threadlocal, primitivetypes and custom object");
        NewThread newThread1 = new NewThread();
        NewThread newThread2 = new NewThread();
        NewThread newThread3 = new NewThread();
        NewThread newThread4 = new NewThread();
        NewThread newThread5 = new NewThread();
        newThread1.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();
        newThread1.run();
        newThread2.run();
        newThread3.run();
        newThread4.run();
        newThread5.run();
        try{
            newThread1.join();
            newThread2.join();
            newThread3.join();
            newThread4.join();
            newThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}