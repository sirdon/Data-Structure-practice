package stack;

public class client {
    public static void main(String[] args) {
        dynamicStack stack = new dynamicStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.display();
        System.out.println(stack.pop());
        stack.peek();
        stack.display();
        stack.size();

        
    }
}