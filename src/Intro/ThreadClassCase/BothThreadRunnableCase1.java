package Intro.ThreadClassCase;

public class BothThreadRunnableCase1 {
    public static void main(String[] args) {

        Thread1 th = new Thread1();
        Thread2 th2 = new Thread2();

        th.start(); // Getting the threads to the run state

        // This thread will transcend from runnable to run
        // as start() method will look for run() and execute
        // it
        th2.start();
    }
}

class Thread1 extends Thread
{
    //run() method which is called
    //    // as soon as thread is started
    @Override
    public void run() {
        System.out.println("thread 1 : running");
    }
}

class Thread2 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread 2 : running");
    }
}
