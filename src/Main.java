import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws IOException {
        //call of test method for  threads with ReentrantLock
        ReentrantLockTest();
       //call of test method for threads with ReentrantReadWriteLock
        reentrantreadWriteLockTest();
       //call of method for testing a thread local, primitive type variable and custom object in synchronized block
       threadLocalTypeTest();


    }

    private static void threadLocalTypeTest() {
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
        newThread1.stop();
        newThread2.stop();
        newThread3.stop();
        newThread3.stop();
        newThread4.stop();
        newThread5.stop();
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
        File file =new File("test.txt");
        System.out.println("ReentrantReadWriteLockExample");
        ReadWriteLockThread readWriteLockThread=new ReadWriteLockThread(0,file);
        ReadWriteLockThread readWriteLockThread1=new ReadWriteLockThread(0,file);
        ReadWriteLockThread readWriteLockThread2=new ReadWriteLockThread(0,file);
        readWriteLockThread.run();
        readWriteLockThread1.run();
        readWriteLockThread2.run();
    }

}


