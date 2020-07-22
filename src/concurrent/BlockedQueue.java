package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BlockedQueue<T> {
    private List queue = new ArrayList<>();
    private int  limit = 10;

    public BlockedQueue(List queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    final Lock lock =
            new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull =
            lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty =
            lock.newCondition();

    // 入队
    void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == limit) {
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作...
            //入队后,通知可出队
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // 等待队列不空
                notEmpty.await();
            }
            // 省略出队操作...
            //出队后，通知可入队
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}