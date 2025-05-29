package Thread.lifecycle;

public class SleepMethod {
    public static void main(String[] args) throws InterruptedException{

        for (int i = 0; i < 5; i++)
        {
            // if IllegalArguementException when sleep time is Negative
            // sleep the main thread for 1 sec
            // for every loop runs
            Thread.sleep(1000);
            System.out.println(i + " ");
        }
    }
}
