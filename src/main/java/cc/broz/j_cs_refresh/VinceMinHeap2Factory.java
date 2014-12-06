package cc.broz.j_cs_refresh;

public class VinceMinHeap2Factory implements MinHeapFactory {
    public <T extends Comparable<? super T>> MinHeap<T> create() {
        return new VinceMinHeap2<T>();
    }
    public <T extends Comparable<? super T>> MinHeap<T> create(int initialSize) {
        return new VinceMinHeap2<T>(initialSize);
    }
}
