package MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();

        stack.push("Alex");
        stack.push("Bob");
        stack.push("Henri");
        stack.push("Ronald");
        System.out.println("stack.size() = " + stack.size());
        System.out.println(stack.toString());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println();
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack.toString());
        System.out.println("stack.size() = " + stack.size());
        System.out.println();

        System.out.println("Stack.remove(2)");
        stack.remove(2);
        System.out.println(stack.toString());
        stack.clear();
        System.out.println(stack.toString());
    }
}
