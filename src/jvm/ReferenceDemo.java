package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {
    public static void main(String[] args) {
        SoftReference<String> softReference = new SoftReference<String>("Hello soft  references");
        System.out.println(softReference.get());
        System.gc();
        WeakReference<Integer> weakReference = new WeakReference<Integer>(12);
        System.out.println(weakReference.get());
        System.gc();

        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> phantomReference = new PhantomReference<String>("Hello", queue);
        System.out.println(phantomReference.get());
    }
}
