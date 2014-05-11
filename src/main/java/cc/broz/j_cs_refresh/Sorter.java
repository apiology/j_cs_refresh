package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public interface Sorter {
    public <I extends Comparable> ArrayList<I> sort(ArrayList<I> arr);
}
