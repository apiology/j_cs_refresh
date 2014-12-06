package cc.broz.j_cs_refresh;

public class JDKMinHeapFactory implements MinHeapFactory {
    public <T extends Comparable<? super T>> MinHeap<T> create() {
        return new JDKMinHeap<T>();
    }
    public <T extends Comparable<? super T>> MinHeap<T> create(int initialSize) {
        return new JDKMinHeap<T>(initialSize);
    }
}
