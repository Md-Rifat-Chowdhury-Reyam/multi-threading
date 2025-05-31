package Thread;


/*
Steps to be followed
1. Create a task(Runnable Object) to execute
2. Create Executor Pool using Executors
3. Pass tasks to Executor Pool
4. Shutdown the Executor Pool
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task class to be executed (Step 1)
class Task implements Runnable
{
    private String name;
    public Task(String n)
    {
        this.name = n;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times

    @Override
    public void run() {
        try {

            for (int i = 0; i < 5; i++)
            {
                if(i == 0)
                {
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization time for task name - " + name + " = " + sdf.format(d));
                }
                else
                {
                    // prints the execution time for every task
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - " + name + " = " + sdf.format(d));
                }

                Thread.sleep(1000);

            }
            System.out.println("Completed " + name);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


public class ThreadPool {
    private static final int Max_Thread = 2; //control the thread execution

    public static void main(String[] args) {

        // creates four tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)

        ExecutorService pool = Executors.newFixedThreadPool(Max_Thread);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}

