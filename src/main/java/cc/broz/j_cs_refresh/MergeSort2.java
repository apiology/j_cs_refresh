package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class MergeSort2 implements Sorter<Comparable> {
	public <I extends Comparable> void sort(List<I> arr) {
		// System.err.println("sort(arr, " + start + ", " + end + ");");
		// System.err.println("sublist is " + arr.subList(start, end + 1));
		
		if (arr.size() <= 1) {
			return;
		} else {
			int numElements = arr.size();
			int middle = arr.size() / 2;
			int end = arr.size() - 1;
			// System.err.println("middle is " + middle);
			sort(arr.subList(0, middle));
			sort(arr.subList(middle, arr.size()));
			merge(arr, middle);
			// System.err.println("merged sublist is " + arr.subList(start, end+1));
			assert SortHelper.isSorted(arr);
		}
		assert SortHelper.isSorted(arr);
	}

	private <I extends Comparable> void merge(List<I> arr, int middle) {
		int size = arr.size();
		List<I> newList = new ArrayList<I>(size);
		int indexOfFirstSide = 0;
		int indexOfSecondSide = middle;
		int end = arr.size() - 1;
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
		int position = 0;
		for (I newItem : newList) {
			assert position <= end;
			arr.set(position, newItem);
			position++;
		}
	}
}
