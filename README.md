Homework project for multithreading with ReentrantLock and 
ReentrantReadWriteLock (project number 3). For the ReentrantLock problem we have implement a problem 
to lock a counter which every thread will try to increment so the increment method in ReentrantLocking class is locked for concurrent access from multiply threads. LockTester is a class which extends Thread and in the Main class we create three threads try to increment the counter and then print it's value.
For ReentrantReadWriteLock problem we use read lock when reading from test.txt file in the ReentrantReadWriteLockFile and write lock when writing to test.txt file. ReadWriteLock is a thread class and in the Main method we create three threads and then we try to concurrently write/read file. 
NewThread is class for showing an example of using ThreadLocal, primitive types and a custom object(Person class) in synchronized block in same method. It can also be started from Main class(all 3 examples starts together).
Other three classes are another example for using a thread local, primitives and custom objects but now from different classes. To start you need to start the main method in SyncDemo class   

Team members: Simeon Iloski, Zorica Srbakova, Elena Lashkoska