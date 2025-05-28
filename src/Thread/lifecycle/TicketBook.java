package Thread.lifecycle;

public class TicketBook implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("State of ticket booking thread while main thread is waiting : " );

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TicketSystem implements Runnable
{

}