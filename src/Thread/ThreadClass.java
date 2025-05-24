package Thread;

public class ThreadClass extends Thread{

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {

        ThreadClass tc = new ThreadClass();

        tc.start();
    }
}
