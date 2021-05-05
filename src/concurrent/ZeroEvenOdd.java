package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ZeroEvenOdd {
    ReentrantLock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();
    volatile int value = 1;
    private int count;

    public ZeroEvenOdd(int count) {
        this.count = count;
    }

    public void printZeroEvenOdd() {
        new Thread(new ThreadZero()).start();
        new Thread(new ThreadEven()).start();
        new Thread(new ThreadOdd()).start();
    }

    class ThreadZero implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i <= count; i++) {
                    while (value % 2 != 1) {
                        zero.await();
                    }
                    System.out.print(0);
                    even.signal();
                    odd.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadEven implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i <= count; i++) {
                    while (value%2 ==1 || value % 4 != 0) {
                        even.await();
                    }
                    System.out.print(value/2);
                    zero.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadOdd implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i <=count; i++) {
                    while (value%2==1 || value % 4 != 2) {
                        odd.await();
                    }
                    System.out.print(value/2);
                    zero.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        zeroEvenOdd.printZeroEvenOdd();
    }
}
