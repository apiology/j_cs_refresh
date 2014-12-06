package cc.broz.j_cs_refresh;

import java.lang.Comparable;

public class VinceMinHeapFactory implements MinHeapFactory {

    public <T extends Comparable<? super T>> MinHeap<T> create() {
        return new VinceMinHeap<T>();
    }

    public <T extends Comparable<? super T>> MinHeap<T> create(int initialSize) {
        return new VinceMinHeap<T>(initialSize);
    }
}
