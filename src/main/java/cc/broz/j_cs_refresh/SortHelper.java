package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class SortHelper {
	public static <I extends Comparable>
		boolean isMoreThanAnythingAfter(ArrayList<I> arr,
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


	public static <I extends Comparable> boolean isSorted(ArrayList<I> arr) {
		return isSorted(arr, 0, arr.size() - 1);
	}

	public static <I extends Comparable> boolean isSorted(ArrayList<I> arr, int start,
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

