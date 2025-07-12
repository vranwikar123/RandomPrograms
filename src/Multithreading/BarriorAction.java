package Multithreading;

public class BarriorAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier Action executed. All threads are released.");
    }
}
