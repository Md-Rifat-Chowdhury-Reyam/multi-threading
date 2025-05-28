package Thread.main;

public class HowToControlMainThread extends Thread {
    public static void main(String[] args) {

        // Getting reference to Main thread
        Thread t = Thread.currentThread();
        // Getting name of Main thread
        System.out.println("Current Thread : " + t.getName());

        // Changing the name of Main thread
        t.setName("Rifat");
        System.out.println("After change the name of main thread : " + t.getName());

        //getting priority of main thread
        System.out.println("The priority of main thread : " + t.getPriority());

        // Setting priority of Main thread to MAX(10)
        t.setPriority(MAX_PRIORITY);
        System.out.println("After change the priority : " + t.getPriority());

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Main Thread ");

        }




        //Main thread creating a child thread
        Thread tChild = new Thread()
        {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++)
                {
                    System.out.println("Child Thread ");

                }
            }
        };

        System.out.println("Child Thread name : " + tChild.getName());
        System.out.println("Child Thread priority : " + tChild.getPriority());

        tChild.start();

    }
}

class Child extends Thread
{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Child Thread ");
        }
    }
}
