package MyHashMap;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTORY = 0.75f;
    private static final int BUCKET_SIZE = 8;

    private Node<K, V>[] table = new Node[DEFAULT_CAPACITY];

    public void put(K key, V value) {
        int hash = hash(key);
        int bucket = (table.length - 1) & hash;
        int nodeCount = 0;
        if (table[bucket] == null) {
            table[bucket] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> next = table[bucket];
            while (next.next != null) {
                if (next.key == key || next.key.equals(key)) {
                    table[bucket].setValue(value);
                    break;
                }
                nodeCount++;
                next = next.next;
            }
            next.next = new Node<K, V>(hash, key, value, null);
        }

        if (nodeCount == BUCKET_SIZE || 100f / (table.length * BUCKET_SIZE) * size() >= DEFAULT_LOAD_FACTORY) {
            resize(table.length * 2);
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int bucket = (table.length - 1) & hash;
        Node<K, V> node = table[bucket];
        if (node == null) {
            throw new IllegalArgumentException("No such key exists");
        }
        for (Node<K, V> n = node; n != null; n = n.next) {
            if (n.getKey() == key || n.getKey().equals(key)) {
                return n.getValue();
            }
        }
        throw new IllegalArgumentException("No such key exists");
    }

    public void remove(K key) {
        int hash = hash(key);
        int bucket = (table.length - 1) & hash;
        Node<K, V> node = table[bucket];
        Node<K, V> previousNode = null;
        if (node == null) {
            throw new IllegalArgumentException("No such key exists");
        }
        if (node.getKey() == key) {
            table[bucket] = node.next;
            if (100f / (table.length * BUCKET_SIZE) * size() < DEFAULT_LOAD_FACTORY) {
                resize(table.length / 2);
            }
            return;
        }
        while (node.next != null) {
            previousNode = node;
            node = node.next;
            if (node.getKey() == key) {
                previousNode.next = node.next;
                if (100f / (table.length * BUCKET_SIZE) * size() < DEFAULT_LOAD_FACTORY) {
                    resize(table.length / 2);
                }
                return;
            }
        }
        throw new IllegalArgumentException("No such key exists");
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
    }

    public int size() {
        int result = 0;
        for (Node<K, V> node : table) {
            if (node == null) {
                continue;
            }
            Node<K, V> nexts = node;
            result++;
            while (nexts.next != null) {
                nexts = nexts.next;
                result++;
            }
        }
        return result;
    }

    private void resize(int newCapacity) {
        Node<K, V>[] oldTable = table;
        table = new Node[newCapacity];
        for (Node<K, V> node : oldTable) {
            if (node == null) {
                continue;
            }
            put(node.getKey(), node.getValue());
            Node<K, V> next = node;
            while (node.next != null) {
                next = next.next;
                put(next.getKey(), next.getValue());
            }
        }
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (Node<K, V> node : table) {
            if (node == null) {
                continue;
            }
            Node<K, V> next = node;
            result.append(next).append(", ");
            while (next.next != null) {
                next = next.next;
                result.append(next).append(", ");
            }
        }
        String res;
        if (result.toString().length() == 1) {
            res = result.append("]").toString();
        } else {
            res = result.substring(0, result.length() - 2) + "]";
        }
        return res;
    }


    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }
}
