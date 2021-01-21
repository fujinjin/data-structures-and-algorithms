package function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> function1 = t -> t + 4;
        Function<Integer, Integer> function2 = t -> t * 3;
        System.out.println(function1.apply(5));
        System.out.println(function2.apply(5));
        //两个函数一起计算后的值，先计算function2，再计算function1
        Integer apply2 = function1.compose(function2).apply(3);
        System.out.println(apply2);
    }
}
