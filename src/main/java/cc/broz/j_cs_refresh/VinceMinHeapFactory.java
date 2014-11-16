package cc.broz.j_cs_refresh;

import java.lang.Comparable;

public class VinceMinHeapFactory<T extends Comparable<T>>
    implements MinHeapFactory<T> {

    public MinHeap<T> create() {
        return new VinceMinHeap<T>();
    }

    public MinHeap<T> create(int initialSize) {
        return new VinceMinHeap<T>(initialSize);
    }
}
