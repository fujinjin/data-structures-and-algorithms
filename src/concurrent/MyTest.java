package concurrent;

import java.util.concurrent.CountDownLatch;

public class MyTest {
    private int count = 0;

    public int get() {
        return count;
    }

    public void set(int v) {
        count = v;
    }

    public synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            set(get() + 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        MyTest myTest = new MyTest();
        int idx = 0;
        while (idx++ < 2) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myTest.add10K();
                    countDownLatch.countDown();
                }
            }
            ).start();
        }
        countDownLatch.await();
        System.out.println(myTest.get());
    }
}
