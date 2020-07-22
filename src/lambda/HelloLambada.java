package lambda;

public class HelloLambada {
    public static void main(String[] args) {
        Hello hello = param->param + "World";
        System.out.println(hello.msg("hello, "));
    }
}
