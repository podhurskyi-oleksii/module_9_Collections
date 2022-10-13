package MyLinkedList;

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyLinkedList() {
        createEmptyLinkedList();
    }

    public void add(T data) {
        if (size() == 0) {
            first.setData(data);
        } else if (size() == 1) {
            last.setData(data);
        } else {
            Node<T> newNode = last;
            last = new Node<>(data, null, newNode);
            newNode.setNext(last);
        }
        size++;
    }

    public T get(int index) {
        checkIsIndexOk(index);
        checkSize();

        Node<T> desired = first;
        for (int i = 0; i < index; i++) {
            desired = desired.getNext();
        }
        return desired.getData();
    }

    public void remove(int index) {
        checkIsIndexOk(index);
        checkSize();

        if (index == 0) {
            first = first.getNext();
            first.setPrev(null);
            size--;
        } else if (index == (size() - 1)) {
            last = last.getPrev();
            last.setNext(null);
            size--;
        } else {
            Node<T> next;
            Node<T> previous;
            Node<T> desire = first;
            for (int i = 0; i < index; i++) {
                desire = desire.getNext();
            }
            next = desire.getNext();
            previous = desire.getPrev();
            previous.setNext(next);
            next.setPrev(previous);
            size--;
        }
    }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.getNext();
            x.setData(null);
            x.setNext(null);
            x.setPrev(null);
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    private void checkIsIndexOk(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", size: " + size());
        }
    }

    private void checkSize() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("List is empty!");
        }
    }

    private void createEmptyLinkedList() {
        first = new Node<>();
        last = new Node<>();
        first.setNext(last);
        last.setPrev(first);
        size = 0;
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node() {
            setData(null);
            setNext(null);
            setPrev(null);
        }

        public Node(T data, Node<T> next, Node<T> prev) {
            setData(data);
            setNext(next);
            setPrev(prev);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}