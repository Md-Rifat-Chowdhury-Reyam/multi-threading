package Thread.safety;

public class Syncronization {
    public static void main(String[] args) {

         B b = new B();
         Thread t1 = new Thread(b);
         Thread t2 = new Thread(b);

         t1.setName("Thread A");
         t2.setName("Thread B");
         t1.start();
         t2.start();
    }
}

class A
{
    synchronized void sum(int n)
    {
        //creating a thread instance
        Thread t = Thread.currentThread(); //cause of currentThread() is a static method that's why define here;
        for (int i = 0 ; i < 5; i++)
        {
            System.out.println(t.getName() + " : " + (n + i));
        }
    }
}

class B extends Thread
{
    A a = new A();

    @Override
    public void run() {
        a.sum(10);
    }
}