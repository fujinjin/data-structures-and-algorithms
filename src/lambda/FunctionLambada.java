package lambda;

public class FunctionLambada {

    public FunctionSub functionSub = new FunctionSub();

    public String getValid(String s1, String s2) {
        return functionSub.load(s1, s2, this::getNew);
    }

    public static void main(String[] args) {
        FunctionLambada functionLambada = new FunctionLambada();
        System.out.println(functionLambada.getValid("1","2"));
        System.out.println(functionLambada.getValid("2","2"));
        System.out.println(functionLambada.getValid("2","3"));
    }

    private String getNew(String s) {
        if (s.equalsIgnoreCase("12")){
            return "new String";
        }
        return "null";
    }
}
