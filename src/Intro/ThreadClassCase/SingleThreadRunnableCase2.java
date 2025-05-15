package Intro.ThreadClassCase;

public class SingleThreadRunnableCase2 {
    public static void main(String[] args) {

        ThreadOne td1 = new ThreadOne();
        ThreadTwo td2 = new ThreadTwo();

        td1.start();
        td2.start();
    }
}


class ThreadOne extends Thread
{

    public void run() {
        System.out.println("thread 1 is runnable");
           }
}
class ThreadTwo extends Thread {

    // Method
    public void show() {

        // Print statement when thread is called
        System.out.println("Thread 2");
    }
}
