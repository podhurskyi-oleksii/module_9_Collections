package MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<String>();

        System.out.println("queue.size() = " + queue.size());
        queue.add("Alex");
//        queue.add("Bob");
//        queue.add("Jon");
//        queue.add("Bill");
//        queue.add("William");

        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.toString());
        System.out.println();

//        System.out.println("Queue remove(index)");
//        queue.remove(3);
//        System.out.println("queue.size() = " + queue.size());
//        System.out.println(queue.toString());
//        System.out.println();
//
//        System.out.println("queue.peek() = " + queue.peek());
//        System.out.println("queue.size() = " + queue.size());
//        System.out.println();

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.toString());
        System.out.println();

        queue.clear();
        System.out.println("queue.clear()");
        System.out.println(queue.toString());
    }
}
