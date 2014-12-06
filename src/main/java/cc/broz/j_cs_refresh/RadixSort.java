package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class RadixSort implements RadixableSorter {
    int maxValueOfDigit;

    public RadixSort(int maxValueOfDigit) {
        this.maxValueOfDigit = maxValueOfDigit;
    }
    
    public <I extends Radixable> void sort(List<I> arr) {
        int i = 0;
        while (true) {
            if (hasNoDigits(arr, i)) {
                break;
            }
            List<RepresentativeInteger> arrAsDigits = new RadixSortedDigitList<I>(arr, i);
            stableSort(arrAsDigits);
            i++;
        }
    }

    public <I extends Radixable> boolean hasNoDigits(List<I> arr, int i) {
        throw new IllegalStateException("Implement me!");
    }

    private void stableSort(List<RepresentativeInteger> a) {
        ArrayList<RepresentativeInteger> b = new ArrayList<>(a);
        int k = maxValueOfDigit;
        int size = a.size();
        
        int[] c = new int[k+1];
        //
        // initialized to zero
        //
        // http://stackoverflow.com/questions/3426843/what-is-the-default-initialization-of-an-array-in-java
        for (int j = 0; j < a.size(); j++) {
            c[a.get(j).asInt()] = c[a.get(j).asInt()] + 1;
        }
        // C[i] now contains the number of elements equal to i
        for (int i = 1; i <= k; i++) {
            c[i] = c[i] + c[i-1];
        }
        // C[i] now contains the number of elements less than or equal to i
        for (int j = size - 1; j >= 0; j--) {
            b.set(c[a.get(j).asInt() - 1], a.get(j));
            c[a.get(j).asInt()]--;
        }
        for (int i = 0; i < size; i++) {
            a.set(i, b.get(i));
        }
    }
}
