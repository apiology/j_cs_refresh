package cc.broz.j_cs_refresh;

import java.util.List;

public class QuickSort2<I extends Comparable> implements Sorter<I> {
	public void sort(List<I> arr) {
		if (arr.size() <= 1) {
			return;
		} else {
			int idx = partition(arr);
			sort(arr.subList(0, idx));
			sort(arr.subList(idx+1, arr.size()));
		}
	}

	private int partition(List<I> arr) {
		int left = 0;
		int right = arr.size() - 1;
		I partitionVal = arr.get(0);
		while (left < right) {
			while (arr.get(left).compareTo(partitionVal) < 0) left++;
			while (arr.get(right).compareTo(partitionVal) > 0) right--;
			if (left < right) {
				swap(arr, left, right);
			}
		}
		assert left == right;
		assert arr.get(left) == partitionVal;
		return left;
	}

	private void swap(List<I> arr, int i, int j) {
		I ival = arr.get(i);
		I jval = arr.get(j);
		arr.set(i, jval);
		arr.set(j, ival);
	}
}
