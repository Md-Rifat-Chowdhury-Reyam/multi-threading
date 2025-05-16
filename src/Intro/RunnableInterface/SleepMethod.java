package Intro.RunnableInterface;

public class SleepMethod {
    public static void main(String[] args) {

        Runnable r1 = new Thd1();
        Runnable r2 = new Thd2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
class Thd1 implements Runnable
{
    @Override
    public void run() {

        for (int  i = 0; i <= 5 ; i++)
        {
            System.out.println("I am Thread 1  --> " + i );

            try {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.getMessage();
            }
        }
    }
}

class Thd2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++)
        {
            System.out.println("I am Thread 2 --> " + i);

            try {

                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.getMessage();
            }
        }
    }
}

