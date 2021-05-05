package array;

import java.util.concurrent.atomic.AtomicLong;

public class SingleObject {

    private AtomicLong id;

    private static volatile SingleObject instance;

    private final static String lock = "lock";

    private SingleObject() {

    }

    public static SingleObject getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance =  new SingleObject();
                }
            }
        }
        return instance;
    }

    public AtomicLong getId() {
        return id;
    }

}
