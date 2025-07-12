package Multithreading;

public class ThreadSharing {
    static int counter = 0;
    public static class MyTask implements Runnable {

        // The count member variable is shared between multiple threads
        // that are executing the same instance of the MyTask runnable.
        private int count = 0;

        private Object object;

        // The object member variable can be shared between multiple threads if the same object instance
        // is passed to MyTask executing in multiple threads
        public MyTask() {
        }

        public MyTask(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            // i is a local variable created on the thread stack of the current thread
            for (int i = 0; i < 10; i++) {
                counter++;
            }

            System.out.printf("[%s] Count: %d\n", threadName, counter);
        }
    }
    public static void main(String[] args) {
        Object obj = new Object();

        // obj instance is shared between two different Runnable instances
        // therefore both threads have access to the same object instance
        Runnable myTask1 = new MyTask(obj);
        Runnable myTask2 = new MyTask(obj);

        Thread thread1 = new Thread(myTask1, "Thread 1");
        Thread thread2 = new Thread(myTask2, "Thread 2");
        thread1.start();
        thread2.start();
    }
}
