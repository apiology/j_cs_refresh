package cc.broz.j_cs_refresh;

import java.lang.Comparable;

public interface MinHeap<T extends Comparable<? super T>> {
    public void push(T t);
    public T pop();
    public boolean isEmpty();
};
