package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class MergeSort
{
    public static <I extends Comparable> ArrayList<I>
                             mergeSort(ArrayList<I> arr) {
        int size = arr.size();
        ArrayList<I> ret = new ArrayList<I>(size);
        if (size == 0) {
            return ret;
        }
        ret.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            I insertableItem = arr.get(i);
            mergeSortInsert(insertableItem, ret);
        }
        return ret;
    }

    private static <I extends Comparable> void
                              mergeSortInsert(I newCandidateItem,
                                              ArrayList<I> sortedList) {
        int indexOfEmptySpace = sortedList.size();
        sortedList.add(null);
        for( ; indexOfEmptySpace >= 0; indexOfEmptySpace--) {
            if (indexOfEmptySpace == 0) {
                sortedList.set(indexOfEmptySpace, newCandidateItem);
            } else {
                I existingCandidateItem =
                    sortedList.get(indexOfEmptySpace - 1);
                if (existingCandidateItem.compareTo(newCandidateItem) > 0) {
                    sortedList.set(indexOfEmptySpace, existingCandidateItem);
                } else {
                    sortedList.set(indexOfEmptySpace, newCandidateItem);
                    break;
                }
            }
        }
    }
}