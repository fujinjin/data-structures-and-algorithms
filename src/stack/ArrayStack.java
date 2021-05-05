package stack;

public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    public boolean push(String item) {
        if (count == n){
         items = tryGrow(items,n);
        }
        items[count] = item;
        ++count;
        return true;
    }

    private String[] tryGrow(String[] items, int n) {
        this.n = n*2;
        String[] newItems = new String[this.n];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        return newItems;
    }

    public String pop() {
        if (count == 0)
            return null;
        String tmp = items[count - 1];
        --count;
        return tmp;

    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("1");
        stack.push("2");
        stack.push("1");
        stack.push("5");
        stack.push("7");
        stack.push("7");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("7");
        stack.push("5");
        stack.push("7");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
