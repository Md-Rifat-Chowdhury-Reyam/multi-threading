package Intro.Priyority;

public class NormalPriority {
    public static void main(String[] args) {

        Thread11 t1 = new Thread11();
        Thread11 t2 = new Thread11();

        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);

        //         t1.setPriority(Thread.MIN_PRIORITY);
        //        t2.setPriority(Thread.MIN_PRIORITY);

        // t1.setPriority(Thread.MAX_PRIORITY);
        //        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}

class Thread11 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread Running : " + currentThread().getName());

        System.out.println("Thread priority : " + currentThread().getPriority());
    }
}

