package Thread;

public class UsingRunnableInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        UsingRunnableInterface uri = new UsingRunnableInterface();
        //call the thread class
        Thread t = new Thread(uri);
        t.start();

        //waiting for thread to finish before print the final result
        try {
            t.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
