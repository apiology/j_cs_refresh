package cc.broz.j_cs_refresh;

public class JDKMinHeapFactory<T extends Comparable> implements MinHeapFactory {
    public MinHeap<T> create() {
        return new JDKMinHeap();
    }
}
