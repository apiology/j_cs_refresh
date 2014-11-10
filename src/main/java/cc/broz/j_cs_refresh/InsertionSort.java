package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class InsertionSort implements Sorter
{
    public <I extends Comparable> void sort(ArrayList<I> ret) {
		ArrayList<I> input = (ArrayList<I>)ret.clone();
        int size = input.size();
        if (size == 0) {
            return;
        }
		ret.clear();
        ret.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            I insertableItem = input.get(i);
            mergeSortInsert(insertableItem, ret);
        }
    }

    private <I extends Comparable> void mergeSortInsert(I newCandidateItem,
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
