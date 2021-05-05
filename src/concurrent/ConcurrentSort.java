package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSort {
    ReentrantLock lock =new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    volatile int value = 1;
    private int count;
    public ConcurrentSort(int count){
        this.count = count;
    }
    public void printSort(){
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }

    class Thread1 implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i <= count; i++) {
                    while(value>count/3){
                        condition1.await();
                    }
                    System.out.println(i);
                    condition2.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    class Thread2 implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = count/3+1; i <= count; i++) {
                    while(value>count*2/3){
                        condition2.await();
                    }
                    System.out.println(i);
                    condition3.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    class Thread3 implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = count*2/3+1; i <= count; i++) {
                    while(value>count){
                        condition3.await();
                    }
                    System.out.println(i);
                    condition1.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentSort concurrentSort=new ConcurrentSort(30);
        concurrentSort.printSort();
    }
}
