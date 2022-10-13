package MyHashMap;

public class MyHashMapTest {
    public static void main(String[] args) {

        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();

        System.out.println(hashMap.size());

        hashMap.put("Alex", 26);
        hashMap.put("John", 20);
        hashMap.put("Fred", 11);
        hashMap.put("Bill", 87);
        hashMap.put("Frank", 46);

        System.out.println(hashMap.toString());
        System.out.println(hashMap.size());


        System.out.println(hashMap.get("Fred"));
        //System.out.println(hashMap.get("Willy"));

        hashMap.remove("Bill");
        System.out.println(hashMap.toString());
        System.out.println(hashMap.size());

        hashMap.clear();
        System.out.println(hashMap.size());

    }
}
