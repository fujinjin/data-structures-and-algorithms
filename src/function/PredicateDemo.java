package function;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = t -> t > 1;
        boolean test = predicate.test(2);
        boolean test2 = predicate.test(0);
        System.out.println(test);
        System.out.println(test2);
    }

}
