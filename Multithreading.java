/*
===============================================================================
                        MULTITHREADING IN JAVA
===============================================================================

Topics Covered

1. What is Thread?
2. Why Multithreading?
3. Thread Class
4. Runnable Interface
5. Synchronization
6. Race Condition
7. Deadlock (Basic)
8. ExecutorService (Basic)

===============================================================================
                        WHAT IS A THREAD?
===============================================================================

Definition:
A Thread is the smallest unit of execution inside a process.
A process (like a running Java application) can contain multiple threads.

Interview Definition:
"A Thread is a lightweight subprocess that executes independently
within a process."

===============================================================================
                        WHY MULTITHREADING?
===============================================================================

Without Multithreading (Synchronous):
Download File -> Wait -> Open Browser -> Wait -> Play Music
* Problem: One task at a time. The CPU sits idle while waiting.

With Multithreading (Asynchronous/Concurrent):
Download File || Play Music || Open Browser
* Solution: Multiple tasks execute simultaneously, maximizing CPU usage.

===============================================================================
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingDemo {

    public static void main(String[] args) {

        /*
        ============================================================
                        1. THREAD CLASS
        ============================================================
        Here, we create a thread by creating an object of our custom class 
        that extends the 'Thread' class.
        */
        
        MyThread thread1 = new MyThread();

        // WHY start() AND NOT run()?
        // If we call thread1.run(), it will execute like a normal method on the main thread.
        // Calling thread1.start() tells the JVM to allocate a new, separate call stack 
        // for this thread, and then the JVM internally calls the run() method.
        thread1.start();


        /*
        ============================================================
                        2. RUNNABLE INTERFACE
        ============================================================
        This is the preferred way to create threads in modern Java. 
        Because Java only supports single class inheritance, if you extend 'Thread', 
        your class cannot extend any other class. Implementing 'Runnable' keeps your 
        class flexible.
        */

        // We pass an instance of our Runnable class into the Thread constructor.
        Thread thread2 = new Thread(new MyRunnable());

        // Starts the thread on a new execution path.
        thread2.start();


        /*
        ============================================================
                    3. SYNCHRONIZATION & RACE CONDITIONS
        ============================================================
        A "Race Condition" happens when multiple threads try to read, modify, 
        and write data at the exact same time, leading to corrupted or lost data.
        */

        Counter counter = new Counter();

        // Creating Thread 1 using a Lambda expression (a shortcut for Runnable).
        // It will try to increment the counter 1000 times.
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                counter.increment();
        });

        // Creating Thread 2 using a Lambda expression.
        // It will ALSO try to increment the exact same counter 1000 times.
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                counter.increment();
        });

        // Start both threads simultaneously
        t1.start();
        t2.start();

        /* 
        WHY DO WE NEED join()?
        The main thread (which prints the output below) runs independently of t1 and t2.
        If we don't use join(), the main thread will print the counter immediately, 
        likely printing "0" or some partial number before t1 and t2 finish counting.
        join() tells the main thread: "Wait right here until t1 and t2 are completely done."
        */
        try {
            t1.join();
            t2.join();
        }
        catch(Exception e){
            // join() throws InterruptedException if a thread is interrupted while waiting
            e.printStackTrace();
        }

        // Because we used 'synchronized' in the Counter class, this will safely 
        // print exactly 2000. Without 'synchronized', it might print 1987, 1995, etc.
        System.out.println("Counter = " + counter.count);


        /*
        ============================================================
                    4. EXECUTOR SERVICE (THREAD POOLS)
        ============================================================
        Creating new threads manually (Thread t = new Thread()) is expensive 
        for the CPU and memory. 
        ExecutorService manages a "Pool" of reusable threads. Instead of creating 
        a new thread for every task, it assigns tasks to already existing threads.
        */

        // We create a pool with exactly 2 reusable threads.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // We "submit" tasks (Runnables) to the pool. 
        // The ExecutorService decides which thread will handle which task.
        executor.submit(() -> System.out.println("Task 1 executed by " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 2 executed by " + Thread.currentThread().getName()));

        // Always shut down the executor when done, otherwise your Java application 
        // will keep running indefinitely because the thread pool remains active listening for new tasks.
        executor.shutdown();

    }

}

/*
===============================================================================
                CLASS DEFINITIONS
===============================================================================
*/

/*
Method 1: Extending the Thread class
* Advantage: Very straightforward, easy to write.
* Disadvantage: MyThread cannot extend any other class now.
*/
class MyThread extends Thread {

    // The run() method acts as the "main" method for this specific thread.
    // Whatever code is inside here is what the thread will actually execute.
    @Override
    public void run(){
        System.out.println("Thread using Thread class");
    }

}

/*
Method 2: Implementing the Runnable interface
* Advantage: Allows you to extend another class if needed (e.g., class MyRunnable extends Animal implements Runnable).
* This is considered the best practice for standard multithreading.
*/
class MyRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("Thread using Runnable");
    }

}

/*
===============================================================================
                SYNCHRONIZATION (Protecting Data)
===============================================================================
*/

class Counter{

    int count = 0;

    /*
    The 'synchronized' keyword is like a lock on a bathroom door.
    
    Why is it needed here? 
    'count++' is actually 3 steps for the CPU:
    1. Read the current value of count.
    2. Add 1 to it.
    3. Write the new value back to count.
    
    If Thread 1 and Thread 2 both read 'count' at the same time (let's say count is 5),
    they will both add 1 (getting 6), and both write 6. We lost an increment!
    
    'synchronized' ensures only ONE thread can execute this method at a time.
    While Thread 1 is inside, Thread 2 must wait outside the method until Thread 1 finishes.
    */
    synchronized void increment(){
        count++;
    }

}