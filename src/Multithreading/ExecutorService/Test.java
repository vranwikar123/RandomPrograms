package Multithreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // Submit tasks for execution
        executorService.submit(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        executorService.submit(() -> {
            for(int i = 11; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        // Shutdown the executor service
        executorService.shutdown();
    }
}
