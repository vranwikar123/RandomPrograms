package Multithreading;

public class Multithreading {

    public static int statCount = 0;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Thread1(0, 20));
        Thread t2 = new Thread(new Thread2(1, 21));

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
