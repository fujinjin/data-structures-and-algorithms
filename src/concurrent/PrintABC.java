package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    volatile int value = 0;
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
                for (int i = 0; i < count; i++) {
                    while (value%3!=0) {
                        conditionA.await();
                    }
                    System.out.print("A");
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
                for (int i = 0; i < count; i++) {
                    while (value%3!=1) {
                        conditionB.await();
                    }
                    System.out.print("B");
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
                for (int i = 0; i < count; i++) {
                    while (value%3!=2) {
                        conditionC.await();
                    }
                    System.out.println("C");
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
        PrintABC printABC = new PrintABC(5);
        printABC.printABC();
    }
}
