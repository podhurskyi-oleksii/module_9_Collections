package MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();

        System.out.println("list.size() = " + list.size());
        list.add("Alex");
        list.add("Bob");
        list.add("Jon");
        list.add("Bill");
        list.add("William");

        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }
        System.out.println("list.size() = " + list.size());

        System.out.println();
        System.out.println("Removing element 2: " + list.get(2));
        list.remove(2);
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(i) = " + list.get(i));
        }

        list.clear();
    }
}
