package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownPgm
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker(latch, 0);
        Worker worker2 = new Worker(latch, 1);
        Worker worker3 = new Worker(latch, 2);

        Thread thread1 = new Thread(worker1, "T1");
        Thread thread2 = new Thread(worker2, "T2");
        Thread thread3 = new Thread(worker3, "T3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            latch.await();
            System.out.println("All threads completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread exiting..");
    }
}

class Worker implements Runnable
{
    CountDownLatch latch;
    int remainder;
    public Worker(CountDownLatch latch, int remainder)
    {
        this.latch = latch;
        this.remainder = remainder;
    }

    @Override
    public void run()
    {
        try
        {
            for(int i = 0; i < 20; i++)
            {
                if(i % 3 == remainder)
                {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" Count donw action " +Thread.currentThread().getName());
        latch.countDown();
    }
}
