package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class MergeSort2 implements Sorter {
	public <I extends Comparable> void sort(List<I> arr) {
		// System.err.println("SORT(" + arr + ")");
		sort(arr, 0, arr.size() - 1);
		assert SortHelper.isSorted(arr);
	}

	private <I extends Comparable> void sort(List<I> arr, int start, int end) {
		// System.err.println("sort(arr, " + start + ", " + end + ");");
		// System.err.println("sublist is " + arr.subList(start, end + 1));
		
		if (end < 0 || start == end) {
			return;
		} else {
			int numElements = end-start+1;
			int middle = start + numElements/2;
			// System.err.println("middle is " + middle);
			sort(arr, start, middle-1);
			sort(arr, middle, end);
			merge(arr, start, middle, end);
			// System.err.println("merged sublist is " + arr.subList(start, end+1));
			assert SortHelper.isSorted(arr, start, end);
		}
	}

	private <I extends Comparable> void merge(List<I> arr,
											  int start, int middle, int end) {
		int size = end-start+1;
		List<I> newList = new ArrayList<I>(size);
		int indexOfFirstSide = start;
		int indexOfSecondSide = middle;
		while (indexOfFirstSide < middle && indexOfSecondSide <= end) {
			I firstItem = arr.get(indexOfFirstSide);
			I secondItem = arr.get(indexOfSecondSide);
			if (firstItem.compareTo(secondItem) <= 0) {
				newList.add(firstItem);
				indexOfFirstSide++;
			} else {
				newList.add(secondItem);
				indexOfSecondSide++;
			}
		}
		while (indexOfFirstSide < middle) {
			I firstItem = arr.get(indexOfFirstSide);
			newList.add(firstItem);
			indexOfFirstSide++;
		}
		while (indexOfSecondSide <= end) {
			I secondItem = arr.get(indexOfSecondSide);			
			newList.add(secondItem);
			indexOfSecondSide++;
		}
		assert indexOfFirstSide == middle;
		assert indexOfSecondSide == end + 1;
		int position = start;
		for (I newItem : newList) {
			assert position <= end;
			arr.set(position, newItem);
			position++;
		}
	}
}
