package Multithreading;

public class Thread1 implements Runnable {

    private int start;
    private int end;

    public Thread1(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        System.out.println("Thread1 started");
        for (int i = start; i < end; i++) {
            if (i % 2 == 0) {
                System.out.println("Thread1: " + i);
            }
        }
    }
}
