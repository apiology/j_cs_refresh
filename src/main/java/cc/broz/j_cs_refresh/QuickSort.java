package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class QuickSort implements Sorter {
    public <T extends Comparable> ArrayList<T> sort(ArrayList<T> arr) {
        ArrayList<T> ret = (ArrayList<T>)arr.clone();
        quickSortInPlace(ret, 0, ret.size()-1);
        return ret;
    }

    public <T extends Comparable> void quickSortInPlace(ArrayList<T> arr,
                                                        int startIndex,
                                                        int endIndex) {
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
    public <T extends Comparable> int partition(ArrayList<T> arr,
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
