package Multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);  // Three permits
        for (int i = 0; i < 10; i++) {
            new Thread(new SWorker(semaphore)).start();
        }
    }
}

class SWorker implements Runnable {
    private final Semaphore semaphore;

    SWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.tryAcquire();  // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " is working.");
            Thread.sleep((long) (Math.random() * 1000));  // Simulate work
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();  // Release the permit
        }
    }
}