package Thread;

public class DeadLock {
    public static void main(String[] args) {

        try {
            System.out.println("Entering into deadlock ");

            //joining the current thread
            Thread.currentThread().join();
            System.out.println("This will never execute");

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
