package practica1.P9;

import practica1.P8.Sequence;
import java.util.*;

public class Stack<T> extends Sequence {
    List<T> data;

    public Stack() {
        this.data = new ArrayList<T>();
    }

    public Stack(List<T> data) {
        this.data = new ArrayList<T>();
        for (T t : data) {
            this.push(t);
        }
    }

    public void push(T dato) {
        this.data.addFirst(dato);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return data.remove(0);
    }

    public T top() {
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
