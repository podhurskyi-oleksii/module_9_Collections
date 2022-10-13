package MyQueue;

import java.util.StringJoiner;

public class MyQueue<T> {

    private Node<T> first;
    private int size;

    public MyQueue() {
        createNewEmptyQueue();
    }

    private void createNewEmptyQueue() {
        first = new Node<>();
        first.setData(null);
        size = 0;
    }

    public void add(T data) {
        if (size == 0) {
            first.setData(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> lastNode = first;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(newNode);
        }
        size++;
    }

    public void remove(int index) {
        checkIsIndexOk(index);
        checkIsSizeOk();
        Node<T> desired = first;

        if (index == 0) {
            first = first.getNext();
        } else if (index == size() - 1) {
            for (int i = 0; i < size() - 1; i++) {
                desired = desired.getNext();
            }
            desired.setNext(null);
        } else {
            Node<T> previousNode = new Node<>();
            for (int i = 0; i < index; i++) {
                previousNode = desired;
                desired = desired.getNext();
            }
            previousNode.setNext(desired.getNext());
        }
        size--;
    }

    public void clear() {
        checkIsSizeOk();
        for (Node<T> x = first; x != null; ) {
            Node<T> nextNode = x.getNext();
            x.setData(null);
            x.setNext(null);
            x = nextNode;
        }
        first = null;
        size = 0;
    }

    public T peek() {
        checkIsSizeOk();
        return first.getData();
    }

    public T poll() {
        checkIsSizeOk();
        Node<T> node = new Node<>(first.getData());

        if (size() == 1) {
            first = null;
        } else {
            first = (first.getNext());
        }
        size--;
        return node.getData();
    }

    private void checkIsSizeOk() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
    }

    private void checkIsIndexOk(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", size: " + size());
        }
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "MyQueue{queue} = []";
        }

        StringJoiner stringJoiner = new StringJoiner(", ");
        Node<T> node = first;
        for (int i = 0; i < size(); i++) {
            stringJoiner.add(node.getData().toString());
            node = node.getNext();
        }
        return "MyQueue{} = ["
                + stringJoiner
                + "]";
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private Node<T> next;
        private T data;

        public Node() {
            setNext(null);
            setData(data);
        }

        public Node(T data) {
            setData(data);
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
