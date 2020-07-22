package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {
    private Map<K, V> kvMap = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock rLock = readWriteLock.readLock();
    private Lock wLock = readWriteLock.writeLock();

    public V getV(K k) {
        rLock.lock();
        try {
            return kvMap.get(k);
        } finally {
            rLock.unlock();
        }
    }

    public void setKV(K k, V v) {
        wLock.lock();
        try {
            kvMap.put(k, v);
        } finally {
            wLock.unlock();
        }
    }
}
