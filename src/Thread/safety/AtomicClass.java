package Thread.safety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {

    // Creating a variable of
    // class type AtomicInteger
    AtomicInteger count = new AtomicInteger();

    public void increment()
    {
        // Defining increment() method
        // to change value of
        // AtomicInteger variable
        count.incrementAndGet();

    }

    public static void main(String[] args) throws Exception{
        AtomicClass a = new AtomicClass();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++)
                {
                    a.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++)
                {
                    a.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(a.count);
    }
}

