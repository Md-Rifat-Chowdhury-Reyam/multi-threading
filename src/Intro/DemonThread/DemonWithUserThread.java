package Intro.DemonThread;

public class DemonWithUserThread {
    public static void main(String[] args) {

        CheckDemonThread t1 = new CheckDemonThread();
        CheckDemonThread t2 = new CheckDemonThread();
        CheckDemonThread t3 = new CheckDemonThread();


        t2.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();

        //Daemon Thread
        // with users threads where start() is invoked
        // prior before setting thread to Daemon

        t3.setDaemon(true);
    }
}


class CheckDemonThread extends Thread
{
    @Override
    public void run() {
        if (Thread.currentThread().isDaemon())
        {
            System.out.println("I am demon thread " + currentThread().getName());
        }
        else {
            System.out.println("i am user thread " +currentThread().getName());
        }
    }
}