package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class MergeSort implements ComparableSorter
{
    public <I extends Comparable<? super I>> void sort(List<I> arr) {
        mergeSortInPlace(arr, 0, arr.size() - 1);
    }

    private <I extends Comparable<? super I>> void mergeSortInPlace(List<I> arr,
														 int startIndex,
														 int endIndex) {
        int sizeOfSlice = endIndex - startIndex + 1;
        if (sizeOfSlice <= 1) {
            // already sorted
            return;
        } else {
            int middleIndex = findMiddleIndex(startIndex, endIndex);
            mergeSortInPlace(arr, startIndex, middleIndex);
            mergeSortInPlace(arr, middleIndex+1, endIndex);
            mergeSlicesInPlace(arr, startIndex, middleIndex, endIndex);
        }
    }

    private int findMiddleIndex(int startIndex, int endIndex) {
        return (startIndex + endIndex)/2;
    }

    private <I extends Comparable<? super I>> void mergeSlicesInPlace(List<I> arr,
															  int startIndex,
															  int middleIndex,
															  int endIndex)  {
        int sizeOfTotalSlice = endIndex - startIndex + 1;

        int firstIndexOfFirstSegment = startIndex;
        int currentIndexOfFirstSegment = firstIndexOfFirstSegment;
        int lastIndexOfFirstSegment = middleIndex;

        int firstIndexOfSecondSegment = middleIndex+1;
        int currentIndexOfSecondSegment = firstIndexOfSecondSegment;
        int lastIndexOfSecondSegment = endIndex;

        List<I> result = new ArrayList<I>(sizeOfTotalSlice);

        while (currentIndexOfFirstSegment <= lastIndexOfFirstSegment &&
               currentIndexOfSecondSegment <= lastIndexOfSecondSegment) {
            I firstElement = arr.get(currentIndexOfFirstSegment);
            I secondElement = arr.get(currentIndexOfSecondSegment);
            if (firstElement.compareTo(secondElement) < 0) {
                result.add(firstElement);
                currentIndexOfFirstSegment++;
            } else {
                result.add(secondElement);
                currentIndexOfSecondSegment++;
            }
        }
        for (; currentIndexOfFirstSegment <= lastIndexOfFirstSegment;
             currentIndexOfFirstSegment++) {
            I firstElement = arr.get(currentIndexOfFirstSegment);
            result.add(firstElement);
        }
        for (; currentIndexOfSecondSegment <= lastIndexOfSecondSegment;
             currentIndexOfSecondSegment++) {
            I secondElement = arr.get(currentIndexOfSecondSegment);
            result.add(secondElement);
        }
        copyIntoArray(result, arr, startIndex);
    }

    private <I extends Comparable<? super I>> void copyIntoArray(List<I> source,
																 List<I> dest,
																 int destStartingIndex) {
        int sourceIndex = 0;
        int sourceSize = source.size();
        for (int destIndex = destStartingIndex;
             destIndex < destStartingIndex + source.size();
             destIndex++) {
            assert(sourceIndex < sourceSize);
            dest.set(destIndex, source.get(sourceIndex));
            sourceIndex++;
        }
    }
}
