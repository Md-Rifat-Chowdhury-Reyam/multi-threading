package Intro.Priyority;

public class DefaultPriyority {
    public static void main(String[] args) {

        Thread1 obj1 = new Thread1();

        obj1.start();

        Thread1 obj2 = new Thread1();
        obj2.start();

    }
}
class Thread1 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread running : " + currentThread().getName());
        System.out.println("Running thread priority : " + currentThread().getPriority());
    }
}
