package lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------- start ------------");
        new Thread(() -> System.out.println("Thread start")).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("Thread start2");
            System.out.println("hello");
        }).start();
        Thread.sleep(100);
        System.out.println("----------- end -------------");
        Runnable run = () -> System.out.println("Hello World");// 1
        run.run();
        ActionListener listener = event -> System.out.println("button clicked");// 2
        Runnable multiLine = () -> {// 3 代码块
            System.out.print("Hello");
            System.out.println(" Hoolee");
        };
        multiLine.run();
        BinaryOperator<Long> add = (Long x, Long y) -> x + y;// 4
        BinaryOperator<Long> addImplicit = (x, y) -> x + y;

    }
}
