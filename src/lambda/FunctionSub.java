package lambda;

import java.util.function.Function;

public class FunctionSub {

    public String load(String s1, String s2, Function<String, String> func) {
        String cacheKey = s1 + s2;
        if (cacheKey.equalsIgnoreCase("22")) {
            return "new Value";
        }
        return func.apply(cacheKey);
    }
}
