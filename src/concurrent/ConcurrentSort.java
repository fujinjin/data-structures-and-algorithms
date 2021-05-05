package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSort {
    ReentrantLock lock =new ReentrantLock();
    Condition condition = lock.newCondition();
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
                        condition.await();
                    }
                    System.out.println(i);
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
                        condition.await();
                    }
                    System.out.println(i);
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
                        condition.await();
                    }
                    System.out.println(i);
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
