package Intro.Priyority;

public class NormalPriority {
    public static void main(String[] args) {

    }
}

class Thread11 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread Running : " + currentThread().getName());

        System.out.println("Thread priority : " + currentThread().getPriority());
    }
}

