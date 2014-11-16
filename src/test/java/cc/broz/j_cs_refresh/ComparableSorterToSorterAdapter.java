package cc.broz.j_cs_refresh;

import java.util.List;

public class ComparableSorterToSorterAdapter<T extends Comparable<T>> implements Sorter<T> {
	ComparableSorter s;

	public ComparableSorterToSorterAdapter(ComparableSorter s) {
		this.s = s;
	}

	public <I extends T> void sort(List<I> arr) {
		s.sort(arr);
	}
}
