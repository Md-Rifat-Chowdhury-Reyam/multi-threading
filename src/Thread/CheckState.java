package Thread;

public class CheckState {
    public static void main(String[] args) {

        ThreadTwo ttwo = new ThreadTwo();
        ThreadTwo.t1 = new Thread(ttwo);


        System.out.println("Post-spanning, state of t1 is: " +  ThreadTwo.t1.getState());

        // lets invoke start() method on t1
        ThreadTwo.t1.start();

        // Now, Thread t1 is moved to runnable state
        System.out.println("Post invoking of start() method, state of t1 is: "
                + " " +  ThreadTwo.t1.getState());
    }
}

class ThreadOne implements Runnable
{
    @Override
    public void run() {

        // implementing try-catch Block to set sleep state
        // for inactive thread

        try {
            Thread.sleep(10002);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("The state for t1 after it invoked join method() on thread t2 : " + ThreadTwo.t1.getState());

        try
        {
            Thread.sleep(20002);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class ThreadTwo implements Runnable
{
    public static Thread t1;//static to access it in other classes

    @Override
    public void run() {
        ThreadOne tone = new ThreadOne();
        Thread t2 = new Thread(tone);

        t2.start();   // Thread is created and its in ---> new state

        // Now t2 is moved to -->runnable state Which is first stage of -->Action state
        System.out.println("State of t2 Thread, post-calling of start() method is: " + " " + t2.getState());

        // Create a try-catch block to set t1
        // in waiting state
        try {
            Thread.sleep(20002);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("State of Thread t2 after invoking to method sleep() is:"
                + " " + t2.getState());

        try {
            t2.join();
            System.out.println("State of Thread t2 after join() is: " + t2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("State of Thread t1 after completing the execution is: "
                + " " + t1.getState());

    }
}
