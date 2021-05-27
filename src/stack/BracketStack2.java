package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketStack2 {
    private Map<Character, Character> mappings;

    public BracketStack2() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
        this.mappings.put(')', '(');
    }

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<Character>();        int val;

        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (mappings.containsKey(element)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != mappings.get(element)) {
                    return false;
                }
            } else {
                stack.push(element);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketStack2 bracketStack2 = new BracketStack2();
        System.out.println(bracketStack2.isValid("{{()[]}}"));
    }
}
