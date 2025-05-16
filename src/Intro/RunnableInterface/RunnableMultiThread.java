package Intro.RunnableInterface;

public class RunnableMultiThread {

    public static void main(String[] args) {

        Runnable th1 = new Thread1();
        Runnable Th2 = new Thread2();

        Thread ob1 = new Thread(th1);
        Thread ob2 = new Thread(Th2);

        ob1.start();
        ob2.start();

    }
}

class Thread1 implements Runnable
{
    @Override
    public void run() {
        System.out.println("I am Thread 1" );
    }
}
class Thread2 implements Runnable
{
    @Override
    public void run() {
        System.out.println("I am Thread 2");
    }
}


//In your RunnableMultiThread program, the order in which "Thread 1" and "Thread 2" print is not guaranteed. This is because thread execution order in Java (or any multithreaded environment)
//If you run the program multiple times, you might see:
//
//Sometimes Thread 1 prints first.
//
//Sometimes Thread 2 prints first.
//
//Rarely, they might even print in parallel (though with such small tasks, this is less likely).