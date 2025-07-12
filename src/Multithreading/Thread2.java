package Multithreading;

public class Thread2 implements Runnable {
    private int start;
    private int end;

    public Thread2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Thread2 started");
        for (int i = start; i < end; i++) {
            if (i % 2 == 1){
                System.out.println("Thread2: " + i);
            }
        }
    }
}
