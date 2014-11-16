package cc.broz.j_cs_refresh;

import java.util.List;

public class InsertionSort2 implements Sorter<Comparable> {
	public <I extends Comparable> void sort(List<I> arr) {
		int len = arr.size();
		for (int i = 1; i < len; i++) {
			I newItem = arr.get(i);
			for (int j = i-1; j >= 0; j--) {
				assert arr.get(j+1) == newItem;

				I existingItem = arr.get(j);
				if (arr.get(j).compareTo(newItem) <= 0) {
					// if item at index j is smaller or the same size,
					break;
				} else {
					// otherwise swap j and j+1 and continue.					
					arr.set(j+1, existingItem);
					arr.set(j, newItem);
				}
			}
			assert SortHelper.isSorted(arr, 0, i);
		}
	}
}
