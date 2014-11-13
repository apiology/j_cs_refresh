package cc.broz.j_cs_refresh;

import java.util.List;

public interface Sorter<I extends Comparable> {
    public void sort(List<I> arr);
}
