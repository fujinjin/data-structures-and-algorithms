package disign;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumeReentrantLock {

    private static int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produceConsume() {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }

    public static void main(String[] args) {
        ProduceConsumeReentrantLock produceConsume = new ProduceConsumeReentrantLock();
        produceConsume.produceConsume();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 10) {
                        try {
                            notFull.await();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "Produce : " + count);
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "Consume : " + count);
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
