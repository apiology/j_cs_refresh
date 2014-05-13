package cc.broz.j_cs_refresh;

import java.util.PriorityQueue;

public class JDKMinHeap<T extends Comparable> implements MinHeap<T> {
    PriorityQueue pq;

    public JDKMinHeap() {
        pq = new PriorityQueue();
    }
    public JDKMinHeap(int initialSize) {
        pq = new PriorityQueue(initialSize);
    }
    public void push(T t) {
        pq.add(t);
    }
    public T pop() {
        return (T) pq.remove();
    }
    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
