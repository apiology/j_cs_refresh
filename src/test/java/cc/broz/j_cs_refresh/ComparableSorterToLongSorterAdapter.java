package cc.broz.j_cs_refresh;

import java.util.List;

public class ComparableSorterToLongSorterAdapter implements Sorter<MyLong> {
	ComparableSorter s;

	public ComparableSorterToLongSorterAdapter(ComparableSorter s) {
		this.s = s;
	}

	public <I extends MyLong> void sort(List<I> arr) {
		s.sort(arr);
	}
}
