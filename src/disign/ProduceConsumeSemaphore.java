package disign;

import java.util.concurrent.Semaphore;

public class ProduceConsumeSemaphore {
    private static int count = 0;
    private Semaphore notFull = new Semaphore(10);
    private Semaphore notEmpty = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public void printPC(){
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    public static void main(String[] args) {
        ProduceConsumeSemaphore produceConsume = new ProduceConsumeSemaphore();
        produceConsume.printPC();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + "Produce count :" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    notEmpty.release();
                    mutex.release();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "Consume count :" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    notFull.release();
                    mutex.release();
                }
            }
        }
    }
}
