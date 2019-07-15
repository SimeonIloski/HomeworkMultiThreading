import java.io.IOException;

public class ReadWriteLockThread extends Thread {
    private ReentrantReadWriteLockFile reentrantReadWriteLockFile;
    private int counter;
    public ReadWriteLockThread(int counter){
        this.counter=counter;
        this.reentrantReadWriteLockFile=new ReentrantReadWriteLockFile(counter);
    }
    @Override
    public void run(){
        System.out.println("I am writing to file while my current counter value is " + reentrantReadWriteLockFile.getCounter());
        System.out.println("write lock is locked");
        try {
            reentrantReadWriteLockFile.writeInFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("write lock is unlocked");
        System.out.println("current value of the counter is " + reentrantReadWriteLockFile.getCounter());
        System.out.println("read lock is locked");
        String s=reentrantReadWriteLockFile.getFromFile();
        System.out.println("read lock is unlocked");
        System.out.println("String readed from file is "+s);
        System.out.println("current value of the counter is " + reentrantReadWriteLockFile.getCounter());


    }
}
