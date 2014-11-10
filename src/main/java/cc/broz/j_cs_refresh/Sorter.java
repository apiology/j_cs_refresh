package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public interface Sorter {
    public <I extends Comparable> void sort(ArrayList<I> arr);
}
