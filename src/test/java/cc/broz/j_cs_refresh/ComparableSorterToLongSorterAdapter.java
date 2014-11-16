package cc.broz.j_cs_refresh;

import java.util.List;

public class ComparableSorterToLongSorterAdapter implements Sorter<Long> {
	ComparableSorter s;

	public ComparableSorterToLongSorterAdapter(ComparableSorter s) {
		this.s = s;
	}

	public <I extends Long> void sort(List<I> arr) {
		s.sort(arr);
	}
}
