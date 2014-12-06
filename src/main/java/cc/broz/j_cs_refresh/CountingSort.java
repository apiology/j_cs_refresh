package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;

public class CountingSort {
    private int maxValueOfDigit;

    public CountingSort(int maxValueOfDigit) {
        this.maxValueOfDigit = maxValueOfDigit;
    }

    public <I extends IntCastable>
        void stableSort(List<I> input) {
        
        int[] numElementsLessThanOrEqualTo = countElements(input);
        // NUMELEMENTSEQUALTO[i] now contains the number of elements less than or equal to i

        stableSortBasedOnCounts(numElementsLessThanOrEqualTo, input);
    }

    private <I extends IntCastable> void
        stableSortBasedOnCounts(int[] numElementsLessThanOrEqualTo,
                                List<I> input) {
        ArrayList<I> output = new ArrayList<>(input);
        int size = input.size();
        for (int j = size - 1; j >= 0; j--) {
            int jDigit = input.get(j).intValue();
            output.set(numElementsLessThanOrEqualTo[jDigit] - 1, input.get(j));
            numElementsLessThanOrEqualTo[input.get(j).intValue()]--;
        }
        for (int i = 0; i < size; i++) {
            input.set(i, output.get(i));
        }
    }

    /**
     * @return array of the elements less than or equal to the index of the array
     */
    private <I extends IntCastable>
        int[] countElements(List<I> input) {
        
        int[] numElementsEqualTo = new int[maxValueOfDigit+1];
        //
        // initialized to zero
        //
        // http://stackoverflow.com/questions/3426843/what-is-the-default-initialization-of-an-array-in-java
        for (int j = 0; j < input.size(); j++) {
            numElementsEqualTo[input.get(j).intValue()] =
                numElementsEqualTo[input.get(j).intValue()] + 1;
        }
        // NUMELEMENTSEQUALTO[i] now contains the number of elements equal to i

        int[] numElementsLessThanOrEqualTo = numElementsEqualTo;
        for (int i = 1; i <= maxValueOfDigit; i++) {
            numElementsLessThanOrEqualTo[i] = numElementsLessThanOrEqualTo[i] + numElementsLessThanOrEqualTo[i-1];
        }

        return numElementsLessThanOrEqualTo;
    }
}
