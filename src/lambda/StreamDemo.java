package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        String contents = "new test for streams2 3 study1";
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
//        long count = words.stream().filter(w -> w.length() > 4).count();
       List<String> longWords = words.stream().filter(w -> w.length() > 4).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(longWords);
    }
}
