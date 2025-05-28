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

        try {
            Thread.sleep(200);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("State after sleeping Ticket booking Thread : "  + MThd.getState());

        try {
            MThd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State after Ticket booking thread Terminated : " + MThd.getState());


    }

    public static void main(String[] args) {

        TicketSystem ts = new TicketSystem();
        mainThread = new Thread(ts);

        System.out.println("State after creating main Thread : " + mainThread.getState());

       mainThread.start();
        System.out.println("State after stating main thread : " + mainThread.getState());
    }
}