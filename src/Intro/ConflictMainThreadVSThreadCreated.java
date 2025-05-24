package Intro;

public class ConflictMainThreadVSThreadCreated {
    public static void main(String[] args) {

        Thrd1 t1 = new Thrd1();

        t1.start();
    }
}

class Thrd1 extends Thread
{
    int count = 0;

    void incr()
    {
        count++ ;
    }

    @Override
    public void run() {
        incr();
        System.out.println("count : " + count);
    }
}