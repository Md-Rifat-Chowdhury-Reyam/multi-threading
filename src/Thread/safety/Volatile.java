package Thread.safety;

public class Volatile {

    // Initializing volatile variables
    // a, b
    static volatile int a = 0, b = 0;

    static void increment()
    {
        a++;
        b++;
    }

    static void method2()
    {
        System.out.println("a : " + a + " b : " + b);
    }

    public static void main(String[] args) {
        Volatile v = new Volatile();



        Thread t1 = new Thread()
        {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    increment();
                }
            }
        };

        Thread t2 = new Thread()
        {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                 method2();
                }
            }
        };

        t1.start();
        t2.start();


    }
}
