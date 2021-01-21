package function;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "有钱人的生活就是这么朴实无华";
        System.out.println(supplier.get());
    }
}
