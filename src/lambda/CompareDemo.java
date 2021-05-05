package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        String[] words = new String[3];
        words[0] = "ii";
        words[1] = "A";
        words[2] = "b";
        System.out.println(words[0]);
        Arrays.sort(words, (first, second) -> {
            return Integer.compare(first.length(), second.length());
        });
        List<String> list = Arrays.asList(words);
        list.forEach(System.out::println);
        Arrays.sort(words, String::compareToIgnoreCase);
        CompareDemo.repeatMessage("Hello",5);

        List<String> list2 = Arrays.asList(words);
        list2.forEach(System.out::println);

    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
//                Thread.yield();
//                System.out.println(Thread.currentThread());
            }
        };
        new Thread(r).start();
    }
}
