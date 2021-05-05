package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketStackSolution {

    // Hash table that takes care of the mappings.
    private Map<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public BracketStackSolution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String inputBrackets) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < inputBrackets.length(); i++) {
            char c = inputBrackets.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketStackSolution stackSolution = new BracketStackSolution();
        System.out.println(stackSolution.isValid("(}{}{{[]()}}()"));
    }
}
