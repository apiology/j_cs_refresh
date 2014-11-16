package cc.broz.j_cs_refresh;

import java.util.List;

public interface ComparableSorter {
	// but it can sort any thing of that subtype.

    public <I extends Comparable<? super I>> void sort(List<I> arr);
}
