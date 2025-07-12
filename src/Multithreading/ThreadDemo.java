package Multithreading;

public class ThreadDemo {
    private int count = 0;
    private int limit = 100;

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();

        ThreadDemo.PrintEven printEven = td. new PrintEven();
        ThreadDemo.PrintOdd printOdd = td. new PrintOdd();

        Thread t1 = new Thread(printEven);
        Thread t2 = new Thread(printOdd);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

     class PrintEven implements Runnable
     {

        @Override
        public void run() {

            while(count < limit)
            {
                synchronized (ThreadDemo.this)
                {
                    while(count % 2 == 1)
                    {
                        try
                        {
                            ThreadDemo.this.wait();
                        }
                        catch (InterruptedException e)
                        {
                            throw new RuntimeException(e);
                        }
                    }

                    if (count < limit) {
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count++;
                        ThreadDemo.this.notifyAll();
                    }                }
            }
        }
    }

     class PrintOdd implements Runnable{
        @Override
        public void run() {
            while (count < limit) {
                synchronized (ThreadDemo.this) {
                    while (count % 2 == 0) {
                        try {
                            ThreadDemo.this.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (count < limit) {
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count++;
                        ThreadDemo.this.notifyAll();
                    }
                }
            }
        }
    }
}
