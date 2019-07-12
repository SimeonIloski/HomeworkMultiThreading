public class LockTester extends Thread {
   ReentrantLocking reentrantLocking;
   public LockTester(ReentrantLocking reentrantLocking){
       this.reentrantLocking=reentrantLocking;
   }
    @Override
    public   void run(){
        System.out.println("Thread id is "+this.getId());
        System.out.println(this.reentrantLocking.getCounter());
        this.reentrantLocking.incrementCounter();
        System.out.println(this.reentrantLocking.getCounter());
    }
}
