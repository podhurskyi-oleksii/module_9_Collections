package MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        //add()
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        System.out.println("Method add()");
        System.out.println("list.toString() = " + list.toString());
        System.out.println();

        //get()
        System.out.println("Method get()");
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(3) = " + list.get(3));
        System.out.println();

        //size()
        System.out.println("Method size()");
        System.out.println("list.size() = " + list.size());
        System.out.println();


        //remove()
        System.out.println("Method remove()");
        list.remove(3);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toString() = " + list.toString());
        System.out.println();

        //clear()
        System.out.println("Method clear()");
        list.clear();
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toString() = " + list.toString());

    }
}
