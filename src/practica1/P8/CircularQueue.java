package practica1.P8;

import java.util.*;

public class CircularQueue<T> extends Queue<T> {
    public CircularQueue() {
        super();
    }

    public CircularQueue(List<T> data) {
        super(data);
    }

    public T shift() {
        if (isEmpty()) {
            throw new IllegalStateException("CircularQueue is Empty");
        }

        T element = dequeue();
        enqueue(element);
        return element;
    }

}
