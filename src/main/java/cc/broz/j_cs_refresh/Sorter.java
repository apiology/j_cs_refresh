package cc.broz.j_cs_refresh;

import java.util.List;

public interface Sorter {
    public <I extends Comparable> void sort(List<I> arr);
}
