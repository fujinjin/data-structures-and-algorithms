package concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueImitate {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
       new Thread().start();
       queue.add("item1");
        queue.add("item2");
        queue.add("item3");
        queue.add("item4");
        queue.iterator();
        queue.clear();
        System.out.println(queue);
    }

    public void addNew(ConcurrentLinkedQueue<String> queue,String item){
        queue.add(item);
    }
}
