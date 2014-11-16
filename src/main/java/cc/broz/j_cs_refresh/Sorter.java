package cc.broz.j_cs_refresh;

import java.util.List;

// I is the interface required for this thing to be able to sort a given thing
public interface Sorter<I extends Comparable> {
    public <J extends I> void sort(List<J> arr);
}
