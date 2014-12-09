package cc.broz.j_cs_refresh;

import java.util.List;

public class SelectionSort implements ComparableSorter {
    public <I extends Comparable<? super I>> void sort(List<I> arr) {
        while (arr.size() >= 1) {
            swapFirstElementWithSmallest(arr);
            arr = arr.subList(1, arr.size());
        }
    }

    private <I extends Comparable<? super I>> void swapFirstElementWithSmallest(List<I> arr) {
        int indexOfSmallest = indexOfSmallest(arr);
        swap(arr, 0, indexOfSmallest);
    }

    private <I extends Comparable<? super I>> int indexOfSmallest(List<I> arr) {
        int smallestIndexSoFar = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).compareTo(arr.get(smallestIndexSoFar)) < 0) {
                smallestIndexSoFar = i;
            }
        }
        return smallestIndexSoFar;
    }

    private <I extends Comparable<? super I>> void swap(List<I> arr, int a, int b) {
        I aVal = arr.get(a);
        I bVal = arr.get(b);
        arr.set(a, bVal);
        arr.set(b, aVal);
    }
}
