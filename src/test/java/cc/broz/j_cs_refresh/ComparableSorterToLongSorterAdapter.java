package cc.broz.j_cs_refresh;

import java.util.List;

public class ComparableSorterToLongSorterAdapter implements LongSorter {
	ComparableSorter s;

	public ComparableSorterToLongSorterAdapter(ComparableSorter s) {
		this.s = s;
	}

	public void sort(List<Long> arr) {
		s.sort(arr);
	}
}
