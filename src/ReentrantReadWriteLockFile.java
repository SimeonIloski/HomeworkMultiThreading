import java.io.*;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockFile {
    private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    private Scanner scanner;
    private PrintWriter printWriter;
    File file;
    public ReentrantReadWriteLockFile(int counter,File file) {

        this.counter=counter;
        try{
            this.file=file;
            this.scanner=new Scanner(file);
            this.printWriter=new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeInFile() throws IOException {
        writeLock.lock();
        try {
            counter += 1;
            printWriter.write("The current value of the counter is"+counter);
            printWriter.flush();
        } finally {

            writeLock.unlock();

        }
    }

    public String getFromFile() {
        readLock.lock();
        String s="";
        int content;
        try {
            while(scanner.hasNextLine()){
                s+=scanner.nextLine();}
        } finally {
            readLock.unlock();
        }
        return s;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}