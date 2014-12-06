package cc.broz.j_cs_refresh;

import java.util.List;

public interface ComparableSorter {
    public <I extends Comparable<? super I>> void sort(List<I> arr);
}
