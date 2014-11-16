package cc.broz.j_cs_refresh;

public interface MinHeapFactory<I extends Comparable<I>> {
    public MinHeap<I> create();
    public MinHeap<I> create(int initialSize);
}
