package Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo
{
    public static void main(String[] args)
    {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarriorAction());

        CBWorker worker1 = new CBWorker(barrier, 0);
        CBWorker worker2 = new CBWorker(barrier, 1);
        CBWorker worker3 = new CBWorker(barrier, 2);

        Thread thread1 = new Thread(worker1, "T1");
        Thread thread2 = new Thread(worker2, "T2");
        Thread thread3 = new Thread(worker3, "T3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class CBWorker implements Runnable
{
    CyclicBarrier cyclicBarrier;
    int remainder;

    public CBWorker(CyclicBarrier latch, int remainder) {
        this.cyclicBarrier = latch;
        this.remainder = remainder;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (i % 3 == remainder) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try
        {
            cyclicBarrier.await();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        catch (BrokenBarrierException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println(" Barries Await Finished " + Thread.currentThread().getName());
    }
}