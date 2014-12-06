package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class RadixSort implements RadixableSorter {
    int maxValueOfDigit;

    public RadixSort(int maxValueOfDigit) {
        this.maxValueOfDigit = maxValueOfDigit;
    }
    
    public <I extends Radixable> void sort(List<I> arr) {
        if (arr.size() == 0) return;
        int maxNumberOfDigits = maxNumberOfDigits(arr);
        CountingSort sorter = new CountingSort(maxValueOfDigit);
        // start at least significant, work towards most significant
        for (int i = 0; i < maxNumberOfDigits; i++) {
            List<RepresentativeInteger<I>> arrAsDigits =
                new RadixSortedDigitList<I>(arr, i, maxNumberOfDigits);
            sorter.stableSort(arrAsDigits);
        }
    }

    public <I extends Radixable> int maxNumberOfDigits(List<I> arr) {
        return arr.stream().map(x -> x.getNumberOfDigits()).max(Integer::compare).get();
    }
}
