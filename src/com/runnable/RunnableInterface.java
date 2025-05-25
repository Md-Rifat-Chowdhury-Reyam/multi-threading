package com.runnable;

import java.io.FileNotFoundException;

public class RunnableInterface {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        OuterClass oc = new OuterClass();
        Thread t1 = new Thread(oc.mt1);

        t1.start();
    }

    /**
     * The output shows that Runnable can't throw checked exceptions,
     * FileNotFoundException in this case, to the callers, it must handle checked exceptions in the run()
     * but RuntimeExceptions (thrown or auto-generated) are handled by the JVM automatically.
     */
}

class OuterClass
{
    private class MyThread1 implements Runnable
    {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());

            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }


    }

    MyThread1 mt1 = new MyThread1();
}