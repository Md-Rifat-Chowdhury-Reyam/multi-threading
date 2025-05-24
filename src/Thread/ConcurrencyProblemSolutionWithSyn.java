package Thread;

public class ConcurrencyProblemSolutionWithSyn {

    public static void main(String[] args) {
        Counter cnt = new Counter();

        Thread t1 = new CounterThread(cnt);
        Thread t2 = new CounterThread(cnt);
        Thread t3 = new CounterThread(cnt);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count : " + cnt.getCount());
    }
}

class Counter extends Thread
{
    private int count = 0;// count the resource

    // Synchronized method to ensure
    // thread-safe increment
    public synchronized void increment()
    {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread
{
    private Counter counter;

    CounterThread(Counter count)
    {
        this.counter = count;
    }

    @Override
    public void run() {
        System.out.println("Thread is running:");
        for(int i = 0; i <= 1000; i++)
        {
            counter.increment();
        }
    }
}
