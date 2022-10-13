package MyArrayList;

import java.util.StringJoiner;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int indexEnd;

    public MyArrayList() {
        creatNewEmptyArray();
    }

    private void creatNewEmptyArray() {
        data = new Object[DEFAULT_CAPACITY];
        indexEnd = 0;
    }

    public void add(T value) {
        resizeIfNeed();

        data[indexEnd] = value;
        indexEnd++;
    }

    private void resizeIfNeed() {
        if (indexEnd == data.length) {
            Object[] newData = new Object[indexEnd * 2];
            System.arraycopy(data, 0, newData, 0, indexEnd);
            data = newData;
        }
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(data, index + 1, data, index, indexEnd - index - 1);
        this.indexEnd--;
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > data.length || data[index] == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
        }
    }

    public int size() {
        return indexEnd;
    }

    public void clear() {
        creatNewEmptyArray();
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < indexEnd; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }
}
