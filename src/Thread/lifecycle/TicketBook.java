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

        System.out.println("State of ticket booking thread while main thread is waiting : " + TicketSystem.mainThread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TicketSystem implements Runnable
{
   public static Thread mainThread;

    @Override
    public void run() {

        TicketBook TcktBook = new TicketBook();
        Thread MThd = new Thread(TcktBook);

        System.out.println("State after creating new Ticket booking thread : " + MThd.getState());

        MThd.start();

        System.out.println("State after starting ticket booking thread : " + MThd.getState());

    }
}