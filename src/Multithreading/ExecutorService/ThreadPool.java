package Multithreading.ExecutorService;

import java.util.concurrent.*;

public class ThreadPool
{
    private static int call1 = 10;
    private static int call2 = 20;
    private static ExecutorService pool = Executors.newSingleThreadExecutor();

    public static void main(String[] args)
    {
        CallableDemo<Integer> t1 = new CallableDemo<>(call1);
        CallableDemo<Integer> t2 = new CallableDemo<>(call2);

        Future<Integer> f1 = pool.submit(t1);
        Future<Integer> f2 = pool.submit(t2);

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        pool.shutdown();
    }
}

class CallableDemo<Integer> implements Callable<java.lang.Integer>
{
    int sum = 0;
    int limit = 0;

    public CallableDemo(int limit)
    {
        this.limit = limit;
    }
    @Override
    public java.lang.Integer call() throws Exception {
        for(int i = 0; i < limit; i++)
        {
            sum += i;
        }
        return sum;
    }
}
