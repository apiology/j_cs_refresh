package cc.broz.j_cs_refresh;

import java.lang.Comparable;

public interface MinHeapFactory<T extends Comparable> {
    public MinHeap<T> create();
    public MinHeap<T> create(int initialSize);
}
