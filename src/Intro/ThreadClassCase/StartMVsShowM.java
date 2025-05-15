package Intro.ThreadClassCase;

public class StartMVsShowM {
    public static void main(String[] args) {
        Th1 t1 = new Th1();
        Th2 t2 = new Th2();

        t1.start();
        t2.show();

        //though thread 1 is started first but thread 2 will show first
    }
}

class Th1 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread 1 is runnable ");
    }
}

class Th2 extends Thread
{
    public void show()
    {
        System.out.println("Thread 2 show method : ");
    }

}