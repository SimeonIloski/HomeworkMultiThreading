import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LocalThreadTest {
    // Returns the current thread's starting timestamp
    private static int n;
    private static Person person;
    private ThreadLocal<Integer> threadId;
    public LocalThreadTest(ThreadLocal<Integer> threadid){
        this.threadId=threadid;
    }
    public void getTestResult(){
        // using a ThreadLocal variable,primitive type variable and custom object
        synchronized (this) {
            try {
                TimeUnit.SECONDS.sleep(2);
                //getting random value for the thread squared and multiplied with the thread id
                Random random = new Random();
                n = random.nextInt(50);
                n = (n * n) * threadId.get();
                //printing a Thread Local in synchronized block
                System.out.println("Thread id is (printed in synchronized block like a thread local) \t" + threadId.get());
                String name = "personname" + threadId.get();
                String surname = "personsurname" + threadId.get();
                //printing a primitive number in  synchronized block
                System.out.println("The random primitive generated number(in synchronized block) squared and multiplied with current threadID is \t" + n);
                //printing a custom object in  synchronized block
                person=new Person(name,surname);
                System.out.println("My custom created object Person in synchronized block has name \t" + person.getName() + "\t and surname \t" + person.getSurname());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
    }

}
