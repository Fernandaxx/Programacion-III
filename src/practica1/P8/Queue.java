package practica1.P8;

import java.util.*;

public class Queue<T> extends Sequence {
    List<T> data;

    public Queue() {
        this.data = new ArrayList<T>();
    }

    public Queue(List<T> data) {
        this.data = new ArrayList<T>();
        for (T t : data) {
            this.enqueue(t);
        }
    }

    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return data.remove(0);
    }

    public T head() {
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public String toString() {
        String str = "[";
        for (T d : data)
            str = str + d + ", ";
        str = str.substring(0, str.length() - 2) + "]";
        return str;
    }
}
