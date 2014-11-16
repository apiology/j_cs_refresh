package cc.broz.j_cs_refresh;

import java.util.List;

public class QuickSort implements ComparableSorter {
    public <T extends Comparable<T>> void sort(List<T> arr) {
        quickSortInPlace(arr, 0, arr.size()-1);
    }

    public <T extends Comparable<T>> void quickSortInPlace(List<T> arr,
														int startIndex, int endIndex) {
        int sliceSize = endIndex - startIndex + 1;
        if (sliceSize <= 1) {
            return;
        } else {
            int partitionIndex = partition(arr, startIndex, endIndex);
            quickSortInPlace(arr, startIndex, partitionIndex);
            quickSortInPlace(arr, partitionIndex+1, endIndex);
        }
    }

    /**
     * @return index of partition element.
     */
    public <T extends Comparable<T>> int partition(List<T> arr,
												int startIndex,
												int endIndex) {
        // TODO: could use random element to make this on average O(n
        // log n) for all inputs.
        T partitionElement = arr.get(startIndex);
        int forwardIndex = startIndex;
        int reverseIndex = endIndex;
        while (true) {
            while (forwardIndex <= endIndex &&
                   arr.get(forwardIndex).compareTo(partitionElement) < 0) {
                // no problem, this is as it should be.
                forwardIndex++;
            }
            while (reverseIndex >= startIndex &&
                   arr.get(reverseIndex).compareTo(partitionElement) > 0) {
                // no problem, this is as it should be.
                reverseIndex--;
            }
            if (reverseIndex > forwardIndex) {
                // swap
                T temp = arr.get(reverseIndex);
                arr.set(reverseIndex, arr.get(forwardIndex));
                arr.set(forwardIndex, temp);
            } else {
                assert(reverseIndex == forwardIndex);
                assert(arr.get(reverseIndex).equals(partitionElement));
                return reverseIndex;
            }
        }
    }
}
