package function;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello World !");
    }
}
