package practica1.P8;

import java.util.*;

public class DoubleEndedQueue<T> extends Queue<T> {
    public DoubleEndedQueue() {
        super();
    }

    public DoubleEndedQueue(List<T> data) {
        super(data);
    }

    public void enqueueFirst(T dato) {
        super.data.addFirst(dato);

    }
}
