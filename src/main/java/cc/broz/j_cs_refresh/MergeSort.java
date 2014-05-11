package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class MergeSort implements Sorter
{
    public <I extends Comparable> ArrayList<I> sort(ArrayList<I> arr) {
        ArrayList<I> result = (ArrayList<I>)arr.clone();
        mergeSortInPlace(result, 0, arr.size() - 1);
        return result;
    }

    private <I extends Comparable> void mergeSortInPlace(ArrayList<I> arr,
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

    private <I extends Comparable> void mergeSlicesInPlace(ArrayList<I> arr,
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

        ArrayList<I> result = new ArrayList<I>(sizeOfTotalSlice);

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

    private <I extends Comparable> void
                       copyIntoArray(ArrayList<I> source,
                                     ArrayList<I> dest,
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
