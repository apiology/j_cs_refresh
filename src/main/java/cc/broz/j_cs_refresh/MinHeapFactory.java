package cc.broz.j_cs_refresh;

public interface MinHeapFactory {
    public <I extends Comparable<? super I>> MinHeap<I> create();
    public <I extends Comparable<? super I>> MinHeap<I> create(int initialSize);
}
