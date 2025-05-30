package Thread.safety;

public class Final {
    static final int i = 5;
    static int a = 4;

    static void method()
    {

       //if we try to initialize another value of i then compile error.
        System.out.println(i + a);
    }

    public static void main(String[] args) {
        Final.method();
    }
}
