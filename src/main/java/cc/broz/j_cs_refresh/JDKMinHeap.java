package cc.broz.j_cs_refresh;

import java.util.PriorityQueue;

public class JDKMinHeap<T extends Comparable<? super T>> implements MinHeap<T> {
    PriorityQueue<T> pq;

    public JDKMinHeap() {
        pq = new PriorityQueue<T>();
    }
    public JDKMinHeap(int initialSize) {
        pq = new PriorityQueue<T>(initialSize);
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
