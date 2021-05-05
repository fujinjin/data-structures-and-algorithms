package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    volatile int value = 1;
    //打印多少遍
    private int count;

    public PrintABC(int count) {
        this.count = count;
    }

    public void printABC() {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }

    class ThreadA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i < count; i++) {
                    while (value > count / 3) {
                        conditionA.await();
                    }
                    System.out.println(i);
                    conditionB.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = count / 3 + 1; i < count; i++) {
                    while (value > count * 2 / 3) {
                        conditionB.await();
                    }
                    System.out.println(i);
                    conditionC.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadC implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = count * 2 / 3 + 1; i <=count; i++) {
                    while (value > count) {
                        conditionC.await();
                    }
                    System.out.println(i);
                    conditionA.signal();
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
        PrintABC printABC = new PrintABC(30);
        printABC.printABC();
    }
}
