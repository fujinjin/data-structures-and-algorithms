package concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class MyTest2 {
    AtomicLong count = new AtomicLong(0);

    public AtomicLong get() {
        return count;
    }

    public void set(AtomicLong v) {
        count = v;
    }

    void add10K() {
        int idx = 0;
        while (idx++ < 1000000) {
            count.getAndIncrement();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyTest2 myTest2 = new MyTest2();
        int idx = 0;
        while (idx++ < 2) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myTest2.add10K();
                }
            }
            ).start();
        }
        System.out.println(Thread.currentThread());
        System.out.println(myTest2.get());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread());
        System.out.println(myTest2.get());


    }
}
