package cc.broz.j_cs_refresh;

import java.util.List;

public class SortHelper {
	public static <I extends Comparable<I>>
		boolean isMoreThanAnythingAfter(List<I> arr,
										I val,
										int start,
										int end) {
		for (int i = start; i <= end; i++) {
			if (val.compareTo(arr.get(i)) > 0) {
				return true;
			}
		}
		return false;
	}


	public static <I extends Comparable<I>> boolean isSorted(List<I> arr) {
		return isSorted(arr, 0, arr.size() - 1);
	}

	public static <I extends Comparable<I>> boolean isSorted(List<I> arr, int start,
														  int end) {
		for (int i = start; i <= end; i++) {
			if (isMoreThanAnythingAfter(arr, arr.get(i), i+1, end)) {
				System.err.println("Not sorted: " + arr.toString());
				return false;
			}
		}
		return true;
	}
}

